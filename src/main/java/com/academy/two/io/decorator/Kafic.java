package com.academy.two.io.decorator;

import java.util.ArrayList;
import java.util.List;

public class Kafic {

    private List<Beverage> beverages = new ArrayList<Beverage>();

    public Kafic() {
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

}
