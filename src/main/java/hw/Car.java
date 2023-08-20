package hw;

import java.awt.*;

public abstract class Car {
    private String brand;
    private String model;
    private Color color;
    private String bodyType;
    private int wheels;
    private String fuelType;
    private String transmissionType;
    private float engineCapacity;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(String brand, String model, Color color, String frameType, int wheels, String fuelType, String transmissionType, float engineCapacity) {
        this(brand, model);
        this.color = color;
        this.bodyType = frameType;
        this.wheels = wheels;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.engineCapacity = engineCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void move() {
        System.out.println("the car is moving...");
    }

    public void maintenance() {
        System.out.println("the car is serviced...");
    }

    public void gearShift() {
        System.out.println("gear is shifting...");
    }

    public void turnOnLight() {
        System.out.println(" lights on...");
    }

    public void turnOnWipers() {
        System.out.println("wipers on...");
    }
}