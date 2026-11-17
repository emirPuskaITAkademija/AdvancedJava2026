package com.academy.three.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;
    private String email;


    public Person() {
    }

    public Person(String name, String surname, LocalDate birthday, Gender gender, String email) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period period = birthday.until(now);
        return period.getYears();
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + birthday + " " + gender + " " + email;
    }
}
