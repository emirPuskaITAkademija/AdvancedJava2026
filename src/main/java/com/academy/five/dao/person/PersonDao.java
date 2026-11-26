package com.academy.five.dao.person;

import com.academy.five.dao.Dao;
import com.academy.four.model.Gender;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * DB location: URL jdbc:mysql://localhost:3306/human
 * username: root
 * password: root
 *
 *
 * <p>
 * Steps:
 * <li>1. Otvara konekciju s MySQL bazom:  Connection connection = DriverManager.getConnection(URL, username, password) </li>
 * <li>2. Spremiti SQL statements: SELECT, INSERT, UPDATE... PreparedStatement ps = connection.preparedStatment(sqlQuery)</li>
 * <li>3. Izvršimo i obradimo rezultate sqlStatement/SQL upita: ResultSet rs = ps.executeQuery(..)</li>
 * </p>
 *
 * <p>
 * executeQuery -> SELECT
 * executeUpdate -> UPDATE, INSERT, DELETE : int broj pogođenih redova
 * </p>
 */
public class PersonDao implements Dao<Person, Integer>{
    /**
     * Person objekat ćemo prebaciti u jedan red u tabeli u bazi podataka.
     * S jedne strane je Java klasa Person po čijem šablonu
     * treba da je kreiran person objekat koji je ova metoda dobila kao parametar,
     * a s druge strane je person tabel u koju ćemo preko sqlInsert izraza kojeg ćemo
     * parametrizovati sa stvarnim podacima iz person objekta ubaciti u tu tabelu jedan red.
     * <p>
     * objekat <-> red
     * Person <--> person
     * </p>
     *
     * @param person
     */
    @Override
    public void create(Person person) {
        String sqlInsert = """
                INSERT INTO 
                person (name, surname, birthday, gender, email_address)
                VALUES (?, ?, ?, ?, ?)
                """;
        //1. otvaranje konekcije
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             //2. sql statement
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            Date birthday = Date.valueOf(person.getBirthday());
            preparedStatement.setDate(3, birthday);
            preparedStatement.setString(4, person.getGender().toString());
            preparedStatement.setString(5, person.getEmailAddress());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        person.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }

    }

    @Override
    public Person findById(Integer id) {
        String selectByIdSql = """
                SELECT *
                FROM person
                WHERE id = ?;
                """;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdSql);) {
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setSurname(resultSet.getString("surname"));
                    Date birthday = resultSet.getDate("birthday");
                    person.setBirthday(birthday.toLocalDate());
                    String gender = resultSet.getString("gender");
                    person.setGender(Gender.valueOf(gender));
                    person.setEmailAddress(resultSet.getString("email_address"));
                    return person;

                }
            }
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
        return null;
    }


    // JDBC API
    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        String sqlSelect = """
                SELECT *
                FROM person
                """;
        //try-with-resource : koje varijable kreiramo u toj konstrukciji ?
        // odgovor: one varijable koje implementiraju autocloseable interface
        // instanca/varijabla/objekat
        try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sqlSelect); // new PersonStatementWrapper();
            ResultSet resultSet = ps.executeQuery();) {
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                Date birthday = resultSet.getDate("birthday");
                LocalDate birthdate = birthday.toLocalDate();
                person.setBirthday(birthdate);
                String gender = resultSet.getString("gender");
                Gender genderEnum = Gender.valueOf(gender);
                person.setGender(genderEnum);
                person.setEmailAddress(resultSet.getString("email_address"));
                personList.add(person);
            }
            return personList;
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        return List.of();
    }

    @Override
    public void update(Person entity) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
