package com.academy.four.person;

import com.academy.four.model.Person;

@FunctionalInterface
public interface PersonTransformator {
    String transform(Person person);
}
