package com.academy.three;

import com.academy.four.model.Gender;
import com.academy.four.model.Person;
import com.academy.three.reader.PersonCsvReader;

import java.util.Collection;
import java.util.Iterator;

// LAMBDA & METHOD REFERENCING
public class PersonDemo {
    static void main() {
        PersonCsvReader personReader = new PersonCsvReader();
        Collection<Person> personCollection = personReader.readPersons();
        System.out.println("----ČISTKA STARIH UPOSLENIKA------");
//        removePersonsOlderThan(personCollection, 28);
        System.out.println("---------------NAKON ČISTKE-----------------");
        printPersonsOlderThan(personCollection, 30);
        System.out.println("-----------------");
        printPersonsYoungerThan(personCollection, 30);
        System.out.println("-----------------");
        //18 - 30
        printPersonsWithinAgeRange(personCollection, 18, 30);
        System.out.println("-----------------ŽENE----------------------");
        printPersonsWithSpecificGender(personCollection, Gender.FEMALE);
        System.out.println("-----------------MUŠKARCI----------------------");
        printPersonsWithSpecificGender(personCollection, Gender.MALE);
        System.out.println("----------------specifična email domena--------------");
        printPersonsWithEmailDomain(personCollection, "yahoo");

        // LAMBDA -> funkcionalnog interfejsa
        // Kada koristimo LAMBDA operator ?
        // ODGOVOR: kada kreiramo objekte tipa funkcionalnog interfejsa ?
        // Zašto baš funcktionalnog interfejsa ?
        // ODGOVOR: funkcionalni interfejs ima samo jednu metodu koja nema blok koda ili apstraktnu metodu
        // Šta onda lambda -> definira
        // ODGOVOR: ona definira blok koda te metode i može kreirati objekat nad kojim će se pozvati taj blok koda
        PersonTester personTester = (Person p) -> false;
        personTester.test(new Person());
    }

    private static void removePersonsOlderThan(Collection<Person> personCollection, int age) {
        //Zašto ja mogu personCollection objekat koristiti u ENHANCED FOR LOOP ?
        // ODGOVOR: zbog toga što je tipa Iterable<Person>
        //Kaže enhanced for petlja : Ja sam zaključala personCollection i niko ne može pristupati toj kolekciji
        // dok ja s njim ne završim
        Iterator<Person> iterator = personCollection.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge() >= age) {
                iterator.remove();
            }
        }
//        for(Person person : personCollection) {
//            int personAge =  person.getAge();
//            if(personAge>=age) {
//                personCollection.remove(person);
//            }
//        }
    }

    private static void printPersonsWithEmailDomain(Collection<Person> personCollection, String emailDomain) {
        //ENHANCED FOR LOOP
        for (Person person : personCollection) {
            String email = person.getEmail();
            if (email.contains(emailDomain)) {
                System.out.println(person);
            }
        }
    }

    private static void printPersonsWithSpecificGender(Collection<Person> personCollection, Gender gender) {
        for (Person person : personCollection) {
            if (person.getGender() == gender) {
                System.out.println(person);
            }
        }
    }

    private static void printPersonsOlderThan(Collection<Person> personCollection, int age) {
        for (Person person : personCollection) {
            if (person.getAge() >= age) {
                System.out.println(person);
            }
        }
    }

    private static void printPersonsYoungerThan(Collection<Person> personCollection, int age) {
        for (Person person : personCollection) {
            if (person.getAge() < age) {
                System.out.println(person);
            }
        }
    }

    private static void printPersonsWithinAgeRange(Collection<Person> personCollection, int min, int max) {
        for (Person person : personCollection) {
            if (person.getAge() >= min && person.getAge() <= max) {
                System.out.println(person);
            }
        }
    }
}
