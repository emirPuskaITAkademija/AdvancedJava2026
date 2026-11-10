package com.academy.two.io.decorator;

import java.io.*;

public class BeverageConsumer {
    static void main(String[] args) throws FileNotFoundException {
        Beverage beverage = new Caffe();
        printBeverageInfo(beverage);
        beverage = new Tea();
        printBeverageInfo(beverage);

        Beverage caffe = new MilkDecorator(new Caffe());
        printBeverageInfo(caffe);

        Beverage makijato = new CaffeDecorator(new Milk());
        printBeverageInfo(makijato);

        Beverage teaWithMilk = new MilkDecorator(new Tea());
        printBeverageInfo(teaWithMilk);

        Beverage irishCaffe = new WhiskeyDecorator(new MilkDecorator(new Caffe()));
        printBeverageInfo(irishCaffe);

        //byte po byte
        // liniju byte
        //1.0 FileInputStream
        // 2.0 BufferedInputStream
//        new DataInputStream(new BufferedInputStream(new FileInputStream()))
//        InputStream inputStream =  new BufferedInputStream(new FileInputStream("sd"));
        Beverage milkWithCacao = new CacaoDecorator(new Milk());
        printBeverageInfo(milkWithCacao);

        Beverage buckuris = new WhiskeyDecorator(new CacaoDecorator(new MilkDecorator(new Caffe())));
        printBeverageInfo(buckuris);
    }

    static void printBeverageInfo(Beverage beverage) {
        System.out.println(beverage.getName() + " pijem i košta me to " + beverage.cost()+" EURO");
    }
}
