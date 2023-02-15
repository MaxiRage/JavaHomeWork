package OOP_homework_1;

public abstract class Chordal extends Animal {

    public Chordal(String nickname) {
        super(nickname);
    }

    public String feed() {
        return "plants";
    }
}
