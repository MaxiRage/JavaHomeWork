import Shield.Defendable;
import Weapons.Weaponable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Warrior {
    private String name;
    private int healthPoint;
    private Weaponable weapon;
    private Defendable defend;

    @Override
    public String toString() {
        return "Warrior:\n" +
                "name: " + name +
                "\nhealthPoint: " + healthPoint +
                "\nweapon: " + weapon +
                "\ndefend: " + defend + "\n";
    }
}