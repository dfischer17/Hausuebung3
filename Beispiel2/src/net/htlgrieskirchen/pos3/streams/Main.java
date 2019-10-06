/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author dfischer17
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // 2.1
        int[] arr = new Random().ints(10000, 0, 101).toArray();

        // 2.2
        System.out.println("average 0 + 10");
        int[] arr2 = {0, 10};
        Streams s = new Streams();
        System.out.println(s.average(arr2));

        // 2.3
        String[] arr3 = new String[10];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = generateRandomString();
        }

        // 2.4
        System.out.println("abc, xyz upperCase");
        Streams s2 = new Streams();
        String[] arr4 = {"abc", "xyz"};
        List<String> myList = s2.upperCase(arr4);
        myList.forEach(w -> System.out.println(w));

        // 2.5
        System.out.println("weapon with lowest damage");
        Streams s3 = new Streams();
        System.out.println(s3.findWeaponWithLowestDamage(s3.getWeaponList()));
        
        System.out.println("weapon with highest strength");
        Streams s4 = new Streams();
        System.out.println(s4.findWeaponWithHighestStrength(s4.getWeaponList()));
        
        System.out.println("weapons with damage type MISSILE");
        Streams s5 = new Streams();
        System.out.println(s5.collectMissileWeapons(s5.getWeaponList()));
        
        System.out.println("weapon with longest name");
        Streams s6 = new Streams();
        System.out.println(s6.findWeaponWithLongestName(s6.getWeaponList()));
        
        System.out.println("extract weapon names");
        Streams s7 = new Streams();
        s7.toNameList(s7.getWeaponList()).forEach(n -> System.out.println(n));
        
        System.out.println("sum");
        Streams s8 = new Streams();
        System.out.println(s8.sumUpValues(s8.getWeaponList()));
        
        System.out.println("sum hash codes");
        System.out.println(s8.sumUpHashCodes(s8.getWeaponList()));
        
        System.out.println("remove duplicates");
        System.out.println(s8.removeDuplicates(s8.getWeaponList()));
    }

    private static String generateRandomString() {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
