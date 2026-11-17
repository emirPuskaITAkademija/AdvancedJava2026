package com.academy.four.demo;

import com.academy.four.model.Gender;
import com.academy.four.model.Person;
import com.academy.four.person.PersonTester;
import com.academy.four.person.PersonTransformator;
import com.academy.four.reader.PersonCsvReader;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Functional Interface = potreban i dovoljan uslov da interfejs bue funkcionalan je da ima
 * JEDNU I SAMO JEDNU Apstraktnu Metodu/F-ju
 * <p>
 * Kada kreiramo objekte navikli smo da koristimo operator new ?
 * <p>
 * Java je do sada uvijek od nas tražila da poslije new koristimo konstrukt(klasa) koji nije apstrakcija.
 * Zašto ?
 * Zato što kod apstrakcija(interface, apstraktne klase) mogu postojati metode koje nemaju blok koda vezan
 * za sebe.
 *
 * </p>
 * </p>
 */
public class PersonDemonstration {
    static void main(String[] args) {
        PersonCsvReader personCsvReader = new PersonCsvReader();
        Collection<Person> personCollection = personCsvReader.readPersons();
//        PersonTester pTester = new PersonTester(){
//            @Override
//            public boolean test(Person person) {
//                return person.getGender() == Gender.MALE;
//            }
//        };
//        pTester.test(new Person());
//        PersonTester personTester = (Person p) -> true;
//        printPersons(personCollection, p -> true);
//        System.out.println("--------------------------------");
////        printFemalePersons(personCollection);
//        printPersons(personCollection, p -> p.getGender() == Gender.FEMALE);
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getGender() == Gender.MALE);
////        printMalePersons(personCollection);
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getAge() >= 20);
////        printPersonsOlderThan(personCollection, 20);
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getBirthday().isBefore(LocalDate.of(1990, 1, 1)));
////        printPersonsOlderThan(personCollection, LocalDate.of(1990, 1, 1));
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getBirthday().isAfter(LocalDate.of(1990, 1, 1)));
////        printPersonsYoungerThan(personCollection, LocalDate.of(1990, 1, 1));
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getAge() >= 20 && p.getAge() <= 30);
//        System.out.println("--------------------------------");
//        printPersons(personCollection, p -> p.getAge() >= 40);
//        System.out.println("--------------------------------");
//        PersonTransformator transformator = person -> person.getSurname() + ", " + person.getName();
//        printPersons(personCollection, p -> p.getAge() >= 40, transformator);


        Predicate<Person> maleTest = p -> p.getGender() == Gender.MALE;
        Predicate<Person> punoljetnostTest = p -> p.getAge() >= 18;
        Predicate<Person> dusanTest = p -> p.getName().contains("Dušan");
        Consumer<Person> personConsumer = param -> System.out.println(param);
        Consumer<String> stringConsumer = i -> System.out.println(i);
        Function<Person, String> transformer = p -> p.getName() + " " + p.getSurname();

        personCollection
                .stream()
                .filter(maleTest)
                .filter(punoljetnostTest)
                .filter(dusanTest)
                .map(transformer)
                .forEach(stringConsumer);
    }


    /**
     * Kriterij pri obradi elemenata u kolekciji.
     *
     * @param persons
     * @param personTester
     */
    static void printPersons(Collection<Person> persons, PersonTester personTester) {
        // Stil before Java 8
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (personTester.test(person)) {
                System.out.println(person);
            }
        }
    }

    static void printPersons(Collection<Person> persons,
                             PersonTester personTester,
                             PersonTransformator personTransformator) {
//        for (Person person : persons) {
//            if (personTester.test(person)) {
//                String transformed = personTransformator.transform(person);
//                System.out.println(transformed);
//            }
//        }
        persons
                .stream() // 1. izvor streama
                .filter(p -> personTester.test(p)) // 2.filter je jedan tipičan primjer intermediate operacije
                .map(p -> personTransformator.transform(p)) // map
                .forEach(e -> System.out.println(e)); // 3. forEach je metoda koja ne vraća stream nego ga terminria


    }

    static void processPersons(Collection<Person> persons,
                               PersonTester personTester,
                               PersonTransformator personTransformator,
                               Consumer<String> consumer) {
        for (Person person : persons) {
            if (personTester.test(person)) {
                String transformed = personTransformator.transform(person);
                consumer.accept(transformed);
            }
        }
    }

//    // Iterable i Collection
//    static void printPersons(Collection<Person> param) {
//        for (Person person : param) {
//            System.out.println(person);
//        }
//    }
//
//    static void printFemalePersons(Collection<Person> param) {
//        for (Person person : param) {
//            if (person.getGender() == Gender.FEMALE) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printMalePersons(Collection<Person> param) {
//        for (Person person : param) {
//            if (person.getGender() == Gender.MALE) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printPersonsOlderThan(Collection<Person> param, int age) {
//        for (Person person : param) {
//            if (person.getAge() >= age) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printPersonsOlderThan(Collection<Person> param, LocalDate date) {
//        for (Person person : param) {
//            if (person.getBirthday().isBefore(date)) {
//                System.out.println(person);
//            }
//        }
//    }
//
//    static void printPersonsYoungerThan(Collection<Person> param, LocalDate date) {
//        for (Person person : param) {
//            if (person.getBirthday().isAfter(date)) {
//                System.out.println(person);
//            }
//        }
//    }
}
