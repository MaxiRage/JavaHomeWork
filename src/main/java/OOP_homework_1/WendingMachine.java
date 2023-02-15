package OOP_homework_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WendingMachine {
    private Double money = 0.0;
    private final List<Product> products = new ArrayList<>();

    public WendingMachine() {
    }

    public Double getMoney() {
        return this.money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public WendingMachine addProduct(Product product) {
        this.products.add(product);
        return this;
    }

    public Product findProduct(String name) {
        Iterator<Product> var2 = this.getProducts().iterator();

        Product prod;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            prod = var2.next();
        } while (!prod.getName().equals(name));

        return prod;
    }

    public Product buy(String name, Double price) {
        Product something = this.findProduct(name);
        if (something == null) {
            return null;
        } else if (price.equals(something.getPrice())) {
            this.products.remove(something);
            this.money = this.money + price;
            return something;
        } else {
            System.out.println("price is wrong");
            return null;
        }
    }

    public String toString() {
        StringBuilder wdProducts = new StringBuilder();

        for (Product prod : this.getProducts()) {
            wdProducts.append(prod.toString()).append("\n");
        }

        wdProducts.append(this.money).append("\n");
        return wdProducts.toString();
    }
}
