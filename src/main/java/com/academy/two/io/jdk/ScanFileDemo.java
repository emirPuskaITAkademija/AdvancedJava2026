package com.academy.two.io.jdk;

import java.io.*;
import java.util.Scanner;

/**
 * {@link Scanner} -> {@link java.io.BufferedReader} -> {@link java.io.FileReader}
 */
public class ScanFileDemo {
    static void main(String[] args) {
        String basePath = "src/main/resources";
        String srcFileName = "%s/novi.txt".formatted(basePath);

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(srcFileName)))){
            while (scanner.hasNext()) {
                if(scanner.hasNextDouble()){
                    double number =  scanner.nextDouble();
                    System.out.println("Pronađen broj: " +  number);
                }else{
                    String word = scanner.next();
                    System.out.println("Riječ: " + word);
                }
            }
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}
