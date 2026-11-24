package com.academy.five.dao.person;

import com.academy.four.model.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Ova klasa koja predstavlja ili je reprezent MySQL table strukture
 * preporuka je da bude Java Bean.
 * <p>
 * Šta je Java bean ?
 * - Svaki Java Bean je klasa
 * - Svaka klasa nije Java bean.
 * <p>
 * Da bi neka klasa bila Java Bean ona mora zadovoljati neke uslove:
 * <li>1. implements Serializable</li>
 * <li>2. public klasa</li>
 * <li>3. public konstruktor bez parametara</li>
 * <li>4. properties ili atributi moraju biti private</li>
 * <li>5. public getter i setter metode </li>
 * </p>
 */
public class Person implements Serializable, Comparable<Person> {

    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;
    private String emailAddress;

    public Person() {
    }

    public Person(Integer id, String name, String surname, LocalDate birthday, Gender gender, String emailAddress) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

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
        return "%s, %s [%s]  '%s' '%s' '%s'".formatted(
                surname, name, id, birthday, gender, emailAddress
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)) {
            return false;
        }
        Person comparedPerson = (Person) obj;
        return Objects.equals(this.id, comparedPerson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    //p1
    //p2
    // int result =  p1.compareTo(p2)
    // p1 > p2  : veći od nule tj. 1
    // p1 == p2 : jednak nuli tj. 0
    // p1 < p2 : manji od nule tj. -1
    @Override
    public int compareTo(Person o) {
        if(this.id > o.getId()) return 1;
        else if(this.id < o.getId()) return -1;
        else return 0;
    }
}
