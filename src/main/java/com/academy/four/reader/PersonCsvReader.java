package com.academy.four.reader;

import com.academy.four.model.Gender;
import com.academy.four.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class PersonCsvReader implements PersonReader {
    public PersonCsvReader() {
        System.out.println("PersonCsvReader kreiran...");
    }

    @Override
    public Collection<Person> readPersons() {
        String filename = "src/main/resources/persons.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Collection<Person> personCollection = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                Person person = createPersonFromLine(line);
                personCollection.add(person);
            }
            return personCollection;
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            return new ArrayList<>();
        }
    }

    private Person createPersonFromLine(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        String surname = fields[1];
        String birthDate = fields[2];
        String[] splitDateParts = birthDate.split("-");
        int year = Integer.parseInt(splitDateParts[0]);
        int month = Integer.parseInt(splitDateParts[1]);
        int day = Integer.parseInt(splitDateParts[2]);
        LocalDate birthday = LocalDate.of(year, month, day);
        //"MALE"
        Gender gender = Gender.valueOf(fields[3]);
        String email = fields[4];

        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setBirthday(birthday);
        person.setGender(gender);
        person.setEmail(email);
        return person;
    }
}
