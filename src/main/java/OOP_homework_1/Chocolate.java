package OOP_homework_1;

public class Chocolate extends Product {

    private double cocoaContent;

    public Chocolate(String name, Double price) {
        super(name, price);
    }

    public Chocolate(String name, Double price, double cocoaСontent) {
        super(name, price);
        this.cocoaContent = cocoaСontent;
    }

    @Override
    public String toString() {
        return String.format("%s cocoa content = %2.2f  ", super.toString(), this.cocoaContent);
    }
}