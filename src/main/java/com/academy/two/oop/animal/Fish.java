package com.academy.two.oop.animal;

public class Fish extends Animal{
    public Fish(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("brb brb ..");
    }
}
