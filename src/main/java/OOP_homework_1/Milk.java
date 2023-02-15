package OOP_homework_1;

public class Milk extends Product {

    private double fatContent;

    public Milk(String name, Double price) {
        super(name, price);
    }

    public Milk(String name, Double price, double fatContent) {
        super(name, price);
        this.fatContent = fatContent;
    }

    @Override
    public String toString() {
        return String.format("%s fat content = %2.2f  ", super.toString(), this.fatContent);
    }
}
