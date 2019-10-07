/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dfischer17
 */
public class Beispiel1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        List<Weapon> weaponList = new ArrayList<>();
        Printable printer = (n) -> n.forEach((k) -> System.out.println(k.toString()));

        // Objekte aus File in List speichern
        Files.lines(new File("weapons.csv").toPath()).skip(1).forEach((n) -> {
            String[] weaponValues = n.split(";");
            weaponList.add(new Weapon(weaponValues[0], CombatType.valueOf(weaponValues[1]),
                    DamageType.valueOf(weaponValues[2]), Integer.valueOf(weaponValues[3]),
                    Integer.valueOf(weaponValues[4]), Integer.parseInt(weaponValues[5]),
                    Integer.valueOf(weaponValues[6])));
        });

        // Objekte absteigend nach damage sortieren Unit-Test fehlt!
        weaponList.sort((w1, w2) -> {
            return w2.getDamage() - w1.getDamage();
        });

        // Objekte alphabetisch zuerst nach combat dann nach damage type sortieren
        weaponList.sort((w1, w2) -> {
            // CombatType gleich ?
            if (w1.getCombatType().compareTo(w2.getCombatType()) == 0) {
                // DamageType gleich?
                if (w1.getDamageType().compareTo(w2.getDamageType()) == 0) {
                    return w1.getName().compareTo(w2.getName());
                }
                return w1.getDamageType().compareTo(w2.getDamageType());
            }
            return w1.getCombatType().compareTo(w2.getCombatType());
        });

        printer.print(weaponList);
    }

    public boolean testDescendingObjects() {
        List<Weapon> weaponList = new ArrayList<>();
        Printable printer = (n) -> n.forEach((k) -> System.out.println(k.toString()));

        // Objekte aus File in List speichern
        Files.lines(new File("weapons.csv").toPath()).skip(1).forEach((n) -> {
            String[] weaponValues = n.split(";");
            weaponList.add(new Weapon(weaponValues[0], CombatType.valueOf(weaponValues[1]),
                    DamageType.valueOf(weaponValues[2]), Integer.valueOf(weaponValues[3]),
                    Integer.valueOf(weaponValues[4]), Integer.parseInt(weaponValues[5]),
                    Integer.valueOf(weaponValues[6])));
        });

        // Objekte absteigend nach damage sortieren
        weaponList.sort((w1, w2) -> {
            return w2.getDamage() - w1.getDamage();
        });

        if (weaponList.get(0).getDamage() == 17 && weaponList.get(weaponList.length - 1).getDamage()) {
            return true;
        }
        return false;
    }
}
