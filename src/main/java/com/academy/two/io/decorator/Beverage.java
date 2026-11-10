package com.academy.two.io.decorator;

public abstract class Beverage {

    private String name;

    public  Beverage(String name){
        this.name = name;
    }

    public abstract double cost();

    public String getName() {
        return name;
    }
}
