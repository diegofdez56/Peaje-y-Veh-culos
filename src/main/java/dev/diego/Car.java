package dev.diego;

public class Car extends Vehicle {

    public Car(String plate) {
        super(plate);
    }

    @Override
    public double calculateToll() {
        return 100.0;
    }
}