package com.academy.two.io.decorator;

/**
 * Beverage može dekorisati drugi Beverage.
 * Beverage HAS-A Beverage
 *
 * IS-A Beverage
 */
public abstract class BeverageDecorator extends Beverage {

    private Beverage beverage;

    public BeverageDecorator(String name, Beverage beverage) {
        super(name);
        this.beverage = beverage;
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
