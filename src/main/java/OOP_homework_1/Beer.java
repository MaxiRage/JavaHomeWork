package OOP_homework_1;

public class Beer extends Product {
    private Integer alcohol;

    public Beer(String name, Double price) {
        super(name, price);
        this.alcohol = 0;
    }

    public Beer(String name, Double price, Integer alcohol) {
        this(name, price);
        this.alcohol = alcohol;
    }

    public String toString() {
        return String.format("%s alcohol = %d  ", super.toString(), this.alcohol);
    }
}
