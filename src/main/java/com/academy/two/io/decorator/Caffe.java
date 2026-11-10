package com.academy.two.io.decorator;

public class Caffe extends Beverage {
    public Caffe() {
        super("Caffe");
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
