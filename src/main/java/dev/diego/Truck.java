package dev.diego;

public class Truck extends Vehicle {
    private int axles;

    public Truck(String plate, int axles) {
        super(plate);
        this.axles = axles;
    }

    @Override
    public double calculateToll() {
        return 50.0 * axles;
    }
}