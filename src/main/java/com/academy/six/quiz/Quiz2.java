package com.academy.six.quiz;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * A 3 ODGOVOR
 * B 2
 * C 4
 * D 1
 */
public class Quiz2 {
    static void main() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);
        System.out.println(numbers.size());
    }
}
