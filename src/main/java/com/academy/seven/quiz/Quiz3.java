package com.academy.seven.quiz;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;

import java.util.List;
import java.util.TreeSet;

/**
 * Kako TreeSet utvrđuje da su dva elementa duplikati ?
 *
 * A equals() vraća true
 * B hashCode() je jednak
 * C compareTo() ili compare() vraća 0 ODGOVOR
 * D Reference u memoriji su jednake od oba objekta
 *
 *
 */
public class Quiz3 {
    static void main() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.findAll();
        TreeSet<Person> treeSet = new TreeSet<>();
        for (Person person : personList) {
            // compareTo  -> p1.compareTo(p2)
            treeSet.add(person);
        }

        for (Person person : treeSet) {
            System.out.println(person);
        }
    }
}
