package com.academy.two.oop;

import com.academy.two.oop.animal.Cat;
import com.academy.two.oop.animal.Dog;
import com.academy.two.oop.animal.Fish;
import com.academy.two.oop.animal.Hamster;

public class Demo {

    static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog("Lesi");
        person.setAnimal(dog);

        Cat cat = new Cat("Lily");
        person.setAnimal(cat);

        Hamster hamster = new Hamster("Hrčak");
        person.setAnimal(hamster);

        Fish  fish = new Fish("Zlatna ribica");
        person.setAnimal(fish);
    }
}
