package com.academy.two.io.jdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * i18n - de
 *
 *
 *
 * l10n - DE, AT
 *
 *  de-DE
 *  de-AT
 *    1.234,56
 *
 *  en-US
 *    1,234.56
 *  en-GB
 */
public class ScannerSum {
    static void main(String[] args) {
        String basePath = "src/main/resources";
        String srcFileName = "%s/brojevni.txt".formatted(basePath);
        double suma = 0.0;
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(srcFileName)))){
            scanner.useLocale(Locale.GERMAN);
            while (scanner.hasNext()) {
                if(scanner.hasNextDouble()){
                    double broj = scanner.nextDouble();
                    suma += broj;
                }else {
                    scanner.next();
                }
            }
            System.out.println("Suma = " + suma);
        }catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}
