package com.academy.five.dao.person;

import com.academy.four.model.Gender;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Ova klasa koja predstavlja ili je reprezent MySQL table strukture
 * preporuka je da bude Java Bean.
 * <p>
 *     Šta je Java bean ?
 *     - Svaki Java Bean je klasa
 *     - Svaka klasa nije Java bean.
 *
 *     Da bi neka klasa bila Java Bean ona mora zadovoljati neke uslove:
 *     <li>1. implements Serializable</li>
 *     <li>2. public klasa</li>
 *     <li>3. public konstruktor bez parametara</li>
 *     <li>4. properties ili atributi moraju biti private</li>
 *     <li>5. public getter i setter metode </li>
 * </p>
 */
public class Person implements Serializable {

    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;

    public Person() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
