package Weapons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Weapon implements Weaponable {
    protected int pointOfDamage;
}