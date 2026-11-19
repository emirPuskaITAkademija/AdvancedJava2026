package com.academy.five.demo;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;
import com.academy.four.model.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class InsertDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi ime osobe");
        String nameInput = scanner.nextLine();
        System.out.println("Unesi prezime osobe");
        String surnameInput = scanner.nextLine();
        System.out.println("Unesi datum rođenja osobe format yyyy-MM-dd");
        String birthdayInput = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(birthdayInput);
        System.out.println("Unesi spol osobe. MALE or FEMALE");
        String genderInput = scanner.nextLine();
        Gender gender =  Gender.valueOf(genderInput);
        System.out.println("Unesi email adresu");
        String emailInput = scanner.nextLine();

        Person person = new Person();
        person.setName(nameInput);
        person.setSurname(surnameInput);
        person.setBirthday(birthday);
        person.setGender(gender);
        person.setEmailAddress(emailInput);

        PersonDao personDao = new PersonDao();
        personDao.create(person);
        System.out.printf("Insertovan je '%s' i baza mu je dodijelila vrijednost id polja '%s'%n", person.getName(), person.getId());


    }
}
