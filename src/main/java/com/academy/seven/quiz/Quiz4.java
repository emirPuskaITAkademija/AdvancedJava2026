package com.academy.seven.quiz;

import java.util.TreeSet;

/**
 * Koja je osnovna razlika između Comparable i Comparator ?
 * <p>
 * A Ne postoji razlika
 * B Comparable definira prirodni poredak, Comparator alternativni kriterij poređenja ODGOVOR
 * C Comparator služi samo za String
 * D Comparable omogućava više kriterija a Comparator samo jedan
 */
public class Quiz4 {

    static void main() {
        Quiz4 quiz = new Quiz4();
        TreeSet<Quiz4> treeset = new TreeSet<>();
        treeset.add(quiz);

    }
}
