package com.academy.two.io.decorator;

public class CacaoDecorator extends BeverageDecorator {
    public CacaoDecorator(Beverage beverage) {
        super(beverage.getName()+" s kakaom", beverage);
    }

    @Override
    public double cost() {
        return 7.5 + getBeverage().cost();
    }
}
