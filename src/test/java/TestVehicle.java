import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVehicle {

    Car car = new Car("Honda", "Civic", 23);
    Motorcycle motorcycle = new Motorcycle("Honda", "cbr_600", 23);
    @Test
    public void test () {
        //Car также является экземпляром транспортного средства (используя оператор instanceof)
        assertInstanceOf(Vehicle.class, car);

        //Car создается с 4-мя колесами
        assertEquals(car.getNumWheels(), 4);

        //Motorcycle создается с 2-мя колесами
        assertEquals(motorcycle.getNumWheels(), 2);

        //Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive())
        car.testDrive();
        assertEquals(car.getSpeed(), 60);

        //Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);

        //В режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);

        //В режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}