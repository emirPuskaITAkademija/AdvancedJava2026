package com.academy.one.io;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

/**
 * Autori programskog jezika Java su nam već dizajnirali klase za koje moramo znati
 * da postoji i koja im je svrha.
 * <p>
 * FileInputStream extends InputStream
 * FileOutputStream extends OutputStream
 * </p>
 */
public class CopyBytesDemo {
    static void main(String[] args) {
        System.out.println("Unesi naziv fajla kojeg želiš pročitati");
        //InputStream, BufferedInputStream
        InputStream consoleInputStream = System.in;
        Scanner scanner = new Scanner(consoleInputStream);
        String fileName = scanner.nextLine();
        String basePath = "src/main/resources";
        String sourceFilePath = "%s/%s".formatted(basePath, fileName);
        String destinationFilePath = "%s/destination.txt".formatted(basePath);
        // try-with-resource
        try (InputStream inputStream = new FileInputStream(sourceFilePath);
             OutputStream outputStream = new FileOutputStream(destinationFilePath)) {
            int c;
            while ((c = inputStream.read()) != -1) {
                printName(c);
                outputStream.write(c);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
//        finally {
//            fileInputStream.close();
//        }
        System.out.println();
        System.out.println();
        // Kako smo kreirali reader objekat ?
        // Odgovor: kreirali smo ga pozivom konstruktora
        // Gdje smo pozvali konstruktor ?
        // Odgovor: unutar try-with-resource konstrukcije
//        try (Reader reader = new Reader();) {
//        } catch (IOException exception) {
//            System.err.println(exception.getMessage());
//        }
    }


    static void printName(int c){
        if(c == -1){
            return;
        }
        System.out.print((char)c);
    }
}
