package hw;

public class Main {
    public static void main(String[] args) {
        testMobil car = new testMobil(
                "Honda", "Civic"
        );

        car.filling();
        car.move();

        DieselEngineCar dCar = new DieselEngineCar("Toyota", "Mystery");
        dCar.filling();
        GasolineEngineCar gCar = new GasolineEngineCar("Lada", "Sedan");
        gCar.filling();
    }
}