package OOP_homework_1;

public class CursedProducts extends Product {
    private final Integer longevity;

    public CursedProducts(String name, Double price, Integer longevity) {
        super(name, price);
        this.longevity = longevity;
    }

    public String toString() {
        return String.format("%s longevity = %d  ", super.toString(), this.longevity);
    }
}
