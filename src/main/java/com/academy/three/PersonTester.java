package com.academy.three;

import com.academy.four.model.Person;

/**
 * Poseban slučaj interfejsa koji se zove FUNCTIONAL INTERFACE.
 *
 *<p>
 *     POtreabn i dovoljan uslov da interfejs bude funkcionalni je da ima JEDNU
 *     i SAMO JEDNU apdtraktnu metodu.
 *</p>
 */
@FunctionalInterface
public interface PersonTester {

    boolean test(Person person);
}
