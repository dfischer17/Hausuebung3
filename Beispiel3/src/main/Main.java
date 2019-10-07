/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel Fischer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        final List<String> names = Arrays.asList("Tim", "Andi", "Michael");
        final Mapper<String, Integer> intMapper = String::length;
        System.out.println(intMapper.mapAll(names));
        final Mapper<String, String> stringMapper = str -> ">> " + str.toUpperCase() + "<< ";
        final List<String> uppercaseNames = stringMapper.mapAll(names);
        System.out.println(uppercaseNames);
    }    
}
