package com.academy.two.io.decorator;

public class Tea extends Beverage{
    public Tea() {
        super("Čaj");
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
