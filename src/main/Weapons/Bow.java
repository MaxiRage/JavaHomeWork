package Weapons;

import lombok.Getter;

import java.util.Random;
@Getter
public class Bow extends Weapon {

    private final int range;

    public Bow(int pointOfDamage, int range) {
        super(pointOfDamage);
        this.range = range;
    }

    @Override
    public int damage() {
        return new Random().nextInt(0, pointOfDamage);
    }

    @Override
    public String toString() {
        return "Bow (" +
                "range: " + range +
                ", pointOfDamage: " + pointOfDamage +
                ")";
    }
}