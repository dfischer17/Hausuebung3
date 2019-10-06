package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    private List<Weapon> weaponList;

    public Streams() {
        weaponList = fetchData();
    }

    private List<Weapon> fetchData() {
        List<Weapon> weaponList = new ArrayList<>();
        try {
            Files.lines(new File("weapons.csv").toPath()).skip(1).forEach((n) -> {
                String[] weaponValues = n.split(";");
                weaponList.add(new Weapon(weaponValues[0],
                        CombatType.valueOf(weaponValues[1]),
                        DamageType.valueOf(weaponValues[2]),
                        Integer.valueOf(weaponValues[3]),
                        Integer.valueOf(weaponValues[4]),
                        Integer.parseInt(weaponValues[5]),
                        Integer.valueOf(weaponValues[6])));
            });
        } catch (IOException ex) {
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weaponList;
    }

    public double average(int[] numbers) {
        return IntStream.of(numbers).average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min((w1, w2) -> (w1.getDamage() - w2.getDamage())).orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max((w1, w2) -> (w1.getMinStrength() - w2.getMinStrength())).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(w -> w.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream().max((w1, w2) -> w1.getName().length() - w2.getName().length()).orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.getName()).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.getSpeed()).mapToInt(Integer::intValue).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.getValue()).mapToInt(Integer::intValue).sum();
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.hashCode()).mapToInt(Integer::intValue).sum();
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().forEach(w -> w.setValue((int) (w.getValue() * 1.1)));
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }
}
