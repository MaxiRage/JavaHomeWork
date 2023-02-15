package OOP_homework_1;

public class Product {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("name = %s ; price = %2.2f ; ", this.name, this.price);
    }
}
