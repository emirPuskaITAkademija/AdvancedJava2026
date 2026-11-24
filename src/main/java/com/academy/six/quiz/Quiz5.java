package com.academy.six.quiz;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * A  [30, 10, 20, 10]
 * B  [30, 10, 20] ODGOVOR
 * C  [30, 20, 10]
 * D  [10, 20, 30 ]
 */
public class Quiz5 {

    static void main() {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(30);
        set.add(10);
        set.add(20);
        set.add(10);
        System.out.println(set);
    }
}
