package com.academy.two.io.decorator;

public class Milk extends Beverage {
    public Milk() {
        super("Mlijeko");
    }

    @Override
    public double cost() {
        return 1.0;
    }
}
