package Shield;

import lombok.Getter;

import java.util.Random;

@Getter
public class SmallShield extends Defend {

    public int armor;

    public SmallShield(int pointOfDefend, int armor) {
        super(pointOfDefend);
        this.armor = armor;
    }

    @Override
    public int defend() {
        return new Random().nextInt(10, pointOfDefend);
    }

    @Override
    public String toString() {
        return "SmallShield (" +
                "armor: " + armor +
                ", pointOfDefend: " + pointOfDefend +
                ")";
    }
}