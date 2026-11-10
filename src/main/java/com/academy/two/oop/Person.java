package com.academy.two.oop;

import com.academy.two.oop.animal.Animal;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthday;
    //Hoću zavisnost ne od konkretne klase Dog, Cat, Hamster..nego od njihove parent klase: slabija sprega
    private Animal animal;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
