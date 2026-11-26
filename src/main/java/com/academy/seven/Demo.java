package com.academy.seven;

import com.academy.five.dao.person.Person;
import com.academy.five.dao.person.PersonDao;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 *
 *   <p>
 *       Kada lambda ne radi ništa drugo nego samo poziva metodu onda se mi umjesto lambde ->
 *
 *       samo referenciramo na tu metodu.
 *
 *       <p>
 *           Tipovi method referenciranja:
 *           <li>1. Referenca na static method   ImeKlase::staticMethodName</li>
 *           <li>2. Referenca na instancnu metodu specifičnog objekta    imeObjekta::instanceMethodName</li>
 *           <li>3. Referenca na instancnu metodu preko objeknog tipa    TypeOfObject/ImeKlase::instanceMethodName</li>
 *           <li>4. Referenca na konstruktor     ClassName::new </li>
 *       </p>
 *   </p>
 */
public class Demo {
    static void main() {
        // S extends Collection
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.findAll();

        // Lamda ovdje samo poziva konstruktor klase HashSet
        // Kada lambda ne radi ništa drugo do poziva konstruktora onda se samo referenciraj na konstruktor
        Supplier<HashSet<Person>> supplier = () ->  new  HashSet<>();
        Supplier<HashSet<Person>> supplier2 = HashSet::new;
        TreeSet<Person> elements = Utility.transferElements(personList, TreeSet::new);

        //Java 7 stil printanja funkcije
        // objektnoj funkciji object.method()
//        for(Person person : personList){
//            person.print();
//        }
        /**
         Zadatak: iz liste kreiraj niz..
         List: indeksiran pristup , pamti redoslijed , duple elemente
         */
        Person[] personArray = personList.toArray(new Person[personList.size()]);
        class PersonBirthdayComparator implements Comparator<Person> {
            @Override
            public int compare(Person person1, Person person2) {
                LocalDate person1Birthday = person1.getBirthday();
                LocalDate person2Birthday = person2.getBirthday();
                return person1Birthday.compareTo(person2Birthday);
            }
        }

        PersonBirthdayComparator personBirthdayComparator = new PersonBirthdayComparator();
        //Kada lambda ne radi ništa drugo nego samo poziva metodu objekta
        // Onda je shortcut za lambdu refereniranje na tu metodu
        Comparator<Person> comparator = personBirthdayComparator::compare;
        //Kada lambda ne radi ništa drugo nego samo poziva statičku metodu klase
        // Onda je shortcut za lambdu referenciranje na tu statičku metodu
        Comparator<Person> nameSurnameComparator = Demo::uporedi;
        Arrays.sort(personArray, comparator);
        for (Person person : personArray) {
            System.out.println(person);
        }

        //personObject.print()
        //personObject::print
        Consumer<Person> printPerson = Person::print;
        personList.forEach(printPerson);
    }



    static int uporedi(Person p1, Person p2) {
        int result = p1.getName().compareTo(p2.getName());
        if(result == 0) {
            result = p1.getSurname().compareTo(p2.getSurname());
        }
        return result;
    }




}
