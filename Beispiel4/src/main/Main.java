/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.function.Predicate;

/**
 *
 * @author Daniel Fischer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Predicate<Integer> isEven = n -> n % 2 == 0;
        final Predicate<Integer> isPositive = n -> n > -1;
        final Predicate<Integer> isNull = n -> n == 0;

        System.out.println("isEven(6) = " + isEven.test(6));
        System.out.println("isEven(3) = " + isEven.test(3));

        System.out.println("isPositive(7) = " + isPositive.test(7));
        System.out.println("isPosivive(-5) = " + isPositive.test(-5));

        Predicate<String> isShortWord = w -> w.length() < 4;
        System.out.println("hello ist kurz = " + isShortWord.test("hello"));
        System.out.println("hi ist kurz = " + isShortWord.test("hi"));

        System.out.println("4 ist gerade und positv = " + isEven.and(isPositive).test(4));
        System.out.println("-4 ist gerade und positv = " + isEven.and(isPositive).test(-4));
        System.out.println("3 ist ungerade und positv = " + isEven.negate().and(isPositive).test(3));

    }

}
