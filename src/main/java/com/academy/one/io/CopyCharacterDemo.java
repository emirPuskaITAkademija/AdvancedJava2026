package com.academy.one.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * char 16 bit  slovo ili karakter
 * FileReader
 * FileWriter
 *
 */
public class CopyCharacterDemo {
    static void main(String[] args) {
        String basePath = "src/main/resources";
        try(FileReader inputStream = new FileReader("%s/source.txt".formatted(basePath));
            FileWriter outputStream = new FileWriter("%s/target.txt".formatted(basePath))
        ){
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
                outputStream.write((char)c);
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
