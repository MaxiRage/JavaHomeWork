package hw;

public class GasolineEngineCar extends Car implements FillingStation {

    public GasolineEngineCar(String brand, String model) {
        super(brand, model);
        super.setFuelType("Gasoline");
    }

    @Override
    public void filling() {//метод заправки бензином
        System.out.println("Gasoline oil fuel fills up");
    }
}
