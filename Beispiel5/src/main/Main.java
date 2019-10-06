/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 *
 * @author Daniel Fischer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntUnaryOperator i = x -> x * x;
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(n -> n % 2 != 0).map(n -> n * n).sum();
        System.out.println("Die Summe beträgt " + result);
    }
    
}
