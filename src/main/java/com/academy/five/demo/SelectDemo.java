package com.academy.five.demo;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;

public class SelectDemo {
    static void main(String[] args) {
        Integer id = 11;
        PersonDao personDao = new PersonDao();
        Person person = personDao.findById(id);
        System.out.println(person);
    }
}
