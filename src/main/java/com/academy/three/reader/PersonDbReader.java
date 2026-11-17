package com.academy.three.reader;

import com.academy.four.model.Person;

import java.util.Collection;
import java.util.List;

public class PersonDbReader implements PersonReader {
    @Override
    public Collection<Person> readPersons() {
        return List.of();
    }
}
