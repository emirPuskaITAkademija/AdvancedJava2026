package com.academy.six;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;
import com.academy.four.model.Gender;

import java.time.LocalDate;
import java.util.*;

public class SixDemo2 {
    static void main() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.findAll();
        List<String> personNameList = personDao
                .findAll()
                .stream()
                .map(p -> p.getName()+" " + p.getSurname())
                .toList();
        personNameList.forEach(name -> System.out.println(name));
        System.out.println("-------------------TREE SET--------------------");
        Set<String> personNameTreeSet = new TreeSet<>(personNameList);
        personNameTreeSet.forEach(p -> System.out.println(p));

    }
}
