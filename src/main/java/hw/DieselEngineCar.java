package hw;

public class DieselEngineCar extends Car implements FillingStation {

    public DieselEngineCar(String brand, String model) {
        super(brand, model);
        super.setFuelType("Diesel oil");
    }

    @Override
    public void filling() {//метод заправки дизельным топливом
        System.out.println("Diesel oil fuel fills up");
    }
}
