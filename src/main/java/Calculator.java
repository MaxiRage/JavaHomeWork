public class Calculator {

    public double calculateDiscount(double amount, double discount) {
        if (amount < 0 || discount < 0 || discount > 100) {
            throw new ArithmeticException("Invalid arguments");
        }
        double discountAmount = amount * discount / 100;
        return amount - discountAmount;
    }
}
