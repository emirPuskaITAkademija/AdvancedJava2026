package com.academy.two.io.decorator;

public class WhiskeyDecorator extends BeverageDecorator {
    public WhiskeyDecorator(Beverage beverage) {
        super(beverage.getName() + " sa viskijem", beverage);
    }

    @Override
    public double cost() {
        return getBeverage().cost() + 2.5;
    }
}
