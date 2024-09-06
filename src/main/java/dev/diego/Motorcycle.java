package dev.diego;

public class Motorcycle extends Vehicle {

    public Motorcycle(String plate) {
        super(plate);
    }

    @Override
    public double calculateToll() {
        return 50.0;
    }
}