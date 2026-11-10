package com.academy.two.io.jdk;

import java.io.*;

/**
 * linija završava kako ?
 * LINE END zavisi od OS
 * <li>1. \r\n Windows </li>
 * <li>2. \n   Unix </li>
 * <p>
 * Dekorisat ćemo FileReader i FileWriter
 * <p>
 * BufferedReader i PrintWriter
 */
public class CopyLineDemo {
    static void main() {
        String basePath = "src/main/resources";
        String srcFileName = "%s/izvor.txt".formatted(basePath);
        String destFileName = "%s/destinacija.txt".formatted(basePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(srcFileName));
             PrintWriter writer = new PrintWriter(new FileWriter(destFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
