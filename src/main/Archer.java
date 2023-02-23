import Shield.BigShield;
import Weapons.Bow;

public class Archer extends Warrior {

    public Archer(String name, int healthPoint, Bow bow, BigShield bigShield) {
        super(name, healthPoint, bow, bigShield);
    }

    @Override
    public String toString() {
        return "Archer " + super.toString();
    }

    public int shotRange() {
        return ((Bow) getWeapon()).getRange();
    }

}