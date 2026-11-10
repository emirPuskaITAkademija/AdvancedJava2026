package com.academy.two.io.jdk;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * {@link Scanner} -> {@link java.io.BufferedReader} -> {@link java.io.FileReader}
 */
public class ScanDemo {
    static void main(String[] args) {
        PrintStream out = System.out;
        out.println("Unesi neki sadržaj");
        InputStream in = System.in;

        //try-with-resource 1.7
        try(Scanner scanner = new Scanner(in);){
            String unosKorisnika = scanner.nextLine();
            out.println(unosKorisnika);
        }
    }
}
