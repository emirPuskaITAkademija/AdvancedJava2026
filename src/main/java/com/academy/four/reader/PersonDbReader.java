package com.academy.four.reader;

import com.academy.four.model.Gender;
import com.academy.four.model.Person;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <li>1. Ostvariti konekciju na bazu: Connection</li>
 * <li>2. Želimo uraditi neki SQL statement u našem programu: Statement, PreparedStatement...</li>
 * <li>3. Obraditi rezultate izvršavanja SQL statementa: ResultSet </li>
 */
public class PersonDbReader implements PersonReader {
    @Override
    public Collection<Person> readPersons() {
        Collection<Person> persons = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/human";
        String username = "root";
        String password = "root";
        //1. Connection JDBC
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            // 2. PreparedStatement
            String sqlQuery = "SELECT * FROM person";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            // 3. ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("name");
                String lastName = resultSet.getString("surname");
                Date birthdate = resultSet.getDate("birthday");
                LocalDate birthday = birthdate.toLocalDate();
                String genderString = resultSet.getString("gender");
                Gender gender = Gender.valueOf(genderString);
                String email = resultSet.getString("email_address");
                Person person = new Person(firstName, lastName, birthday, gender, email);
                persons.add(person);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return persons;
    }
}
