package com.academy.two.io.decorator;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage.getName() + " s mlijekom", beverage);
    }

    @Override
    public double cost() {
        return getBeverage().cost() + 0.5;
    }
}
