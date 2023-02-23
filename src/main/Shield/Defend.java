package Shield;

public abstract class Defend implements Defendable {
    protected int pointOfDefend;

    public Defend(int pointOfDefend) {
        this.pointOfDefend = pointOfDefend;
    }

    @Override
    public String toString() {
        return "pointOfDefend - " + pointOfDefend;
    }
}