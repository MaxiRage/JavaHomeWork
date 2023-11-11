package hw3.task3;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(42, "Hello");
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println("Pair 1:");
        System.out.println("First: " + pair1.getFirst());
        System.out.println("Second: " + pair1.getSecond());
        System.out.println(pair1);

        System.out.println("\nPair 2:");
        System.out.println("First: " + pair2.getFirst());
        System.out.println("Second: " + pair2.getSecond());
        System.out.println(pair2);
    }
}