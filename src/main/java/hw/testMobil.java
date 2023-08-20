package hw;

public class testMobil extends Car implements FillingStation {
    public testMobil(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void filling() {//метод заправки
        System.out.println("testing car is filling...");
    }
}
