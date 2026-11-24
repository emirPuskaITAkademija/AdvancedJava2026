package com.academy.six;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;
import com.academy.four.model.Gender;

import java.time.LocalDate;
import java.util.*;

public class SixDemo {
    static void main() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.findAll();
        //	16	Nemanja	Stojković	2000-01-01	MALE	nemanja@gmail.com
        Person person = new Person(16, "Nemanja", "Stojković", LocalDate.of(2000, 1, 1), Gender.MALE, "nemanja@gmail.com");
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);
        personList.add(person);

        personList.forEach(p -> System.out.println(p));
        System.out.println("-------------------TREE SET--------------------");
        Set<Person> personTreeSet = new TreeSet<>(personList);
        personTreeSet.forEach(p -> System.out.println(p));

        System.out.println("-------------------LINKED HASH SET--------------------");
        Set<Person> personLinkedHashSet = new LinkedHashSet<>(personList);
        personLinkedHashSet.forEach(p -> System.out.println(p));

        System.out.println("-------------------HASH SET--------------------");

        Set<Person> personSet = new HashSet<>(personList);
        personSet.forEach(p -> System.out.println(p));




        //Enhanced for loop: Iterator
//        for(Person p :  personList) {
//            System.out.println(p);
//        }
        // Spliterator/Stream API
//        personList
//                .stream()
//                .filter(p -> Gender.FEMALE.equals(p.getGender()))
//                .forEach(p -> System.out.println(p));
    }
}
