package com.academy.four.person;

import com.academy.four.model.Person;

@FunctionalInterface
public interface PersonTester {

    //Preduvjet za poziv ove metode ?
    // Postojanje čega ?
    // 1. klase ili interfejsa
    // 2. instance/objekta/varijable kreirane po šablonu klase/interface
    // PersonTester p = new PersonTester();
    // boolean result  = p.test(person);

    // PersonTester p2 = (Person p) -> {  ... };
    // boolean result = p2.test(person);
    boolean test(Person person);
}
