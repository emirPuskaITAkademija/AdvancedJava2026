package com.academy.two.oop.animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Mjau Mjau...");
    }
}
