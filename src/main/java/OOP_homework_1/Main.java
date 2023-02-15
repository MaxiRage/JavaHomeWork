package OOP_homework_1;

/**
 * На основе кода с урока добавить еще один класс продукта,
 * (Молоко, шоколад ,и т.п., можно добавить несколько классов),
 * они должны наследоваться от класса Product,
 * надо переопределить метод toString и попробовать включить эти классы в VendingMachine, вывести список товаров из VendingMachine
 */

public class Main {

    public static void main(String[] args) {
        WendingMachine store = new WendingMachine();
//        store.addProduct(new Product("Lays", 123.45))
//                .addProduct(new Product("fanta", 98.76))
//                .addProduct(new Product("fan", 43.21))
//                .addProduct(new Product("fan", 43.21))
//                .addProduct(new Beer("alcoholfree", 67.89))
//                .addProduct(new Beer("notbeer", 67.89, 99))
//                .addProduct(new CursedProducts("milk", 56.65, 7));

        store.addProduct(new Milk("Oloneckoe", 12.12, 3.5));
        store.addProduct(new Chocolate("Gorkii", 22.12, 55.5));

        System.out.println(store);

        store.buy("Oloneckoe", 12.12);
        store.buy("Gorkii", 22.12);

        System.out.println(store);


//        System.out.println("searching for ay's");
//        System.out.println(store.findProduct("ys"));
//        System.out.println("buying Lay's");
//        store.buy("Lays", 123.45);
//
//        System.out.println(store);
//        System.out.println("buying fan's");
//        store.buy("fan", 43.21);
//
//        System.out.println(store);
//        System.out.println("buying a's");
//        store.buy("fan", 4.1);
//
//        System.out.println(store);
//        System.out.println("buying a's");
//        store.buy("milk", 56.65);
//
//        System.out.println(store);
    }
}
