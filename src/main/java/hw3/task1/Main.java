package hw3.task1;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int num1 = 2;
        long num2 = 4;

        double num3 = 7.5;
        float num4 = 2.5F;

        System.out.println("Деление: " + calculator.divide(num3, num4));
        System.out.println("Вычитание: " + calculator.subtract(num2, num4));
        System.out.println("Умножение: " + calculator.multiply(num3, num4));
        System.out.println("Сумма: " + calculator.sum(num1, num2));
        System.out.println("Вычитание: " + calculator.subtract(num1, num2));
    }
}