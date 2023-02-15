package OOP_homework_1;

public class Pinguin extends  Chordal implements Swimming {

    public Pinguin(String nickname) {
        super(nickname);
    }

    @Override
    public boolean abilitySwim() {
        return true;
    }

    @Override
    public String say() {
        return "kry-kry";
    }
}
