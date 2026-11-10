package com.academy.two.oop.animal;

public class Hamster extends Animal {

    public Hamster(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("hrk hrk..");
    }
}
