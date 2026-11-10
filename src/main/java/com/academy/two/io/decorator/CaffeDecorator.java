package com.academy.two.io.decorator;

public class CaffeDecorator extends BeverageDecorator {
    public CaffeDecorator(Beverage beverage) {
        super(beverage.getName()+" s kafom", beverage);
    }

    @Override
    public double cost() {
        return getBeverage().cost() + 1.5;
    }
}
