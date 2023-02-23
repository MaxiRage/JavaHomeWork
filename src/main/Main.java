import Shield.BigShield;
import Shield.SmallShield;
import Weapons.Bow;
import Weapons.Sword;

public class Main {
    public static void main(String[] args) {

        Squad<Swordmen> comandos = new Squad<>();
        comandos.addWarriorToTeam(new Swordmen("Spartak"
                        , 250
                        , new Sword(25)
                        , new SmallShield(30, 30)))
                .addWarriorToTeam(new Swordmen("LeonidFirst"
                        , 200
                        , new Sword(30)
                        , new SmallShield(50, 30)));

        comandos.forEach(System.out::println);

        Squad<Archer> avengers = new Squad<>();
        avengers.addWarriorToTeam(new Archer("Kutalion"
                        , 150, new Bow(30
                        , 200), new BigShield(100)))
                .addWarriorToTeam(new Archer("Engay"
                        , 130
                        , new Bow(20, 250)
                        , new BigShield(150)));

        avengers.forEach(System.out::println);

        System.out.println(comandos.maxTeamRange());
        System.out.println(avengers.maxTeamRange());

        System.out.println(comandos.minTeamArmor());
        System.out.println(avengers.minTeamArmor());
    }
}