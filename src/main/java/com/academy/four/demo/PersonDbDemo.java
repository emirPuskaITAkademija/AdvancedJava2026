package com.academy.four.demo;

import com.academy.four.model.Gender;
import com.academy.four.model.Person;
import com.academy.four.reader.PersonDbReader;

import java.util.Collection;

public class PersonDbDemo {
    static void main(String[] args) {
        PersonDbReader personDbReader = new PersonDbReader();
        Collection<Person> personCollection = personDbReader.readPersons();
        personCollection
                .stream()
                .filter(person -> person.getGender()== Gender.FEMALE)
                .map(person -> person.getName() + " "  + person.getSurname())
                .forEach(person -> System.out.println(person));
    }
}
