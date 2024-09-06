package dev.diego;

import java.util.ArrayList;
import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private double totalCollected;
    private List<Vehicle> registeredVehicles;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.totalCollected = 0.0;
        this.registeredVehicles = new ArrayList<>();
    }

    // Getters for name and city
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void registerVehicle(Vehicle vehicle) {
        double toll = vehicle.calculateToll();
        totalCollected += toll;
        registeredVehicles.add(vehicle);
        System.out.println("Vehicle with plate " + vehicle.getPlate() + " registered. Toll: $" + toll);
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void printReport() {
        System.out.println("Report of registered vehicles:");
        for (Vehicle vehicle : registeredVehicles) {
            System.out.println("Vehicle with plate: " + vehicle.getPlate() + ", Toll paid: $" + vehicle.calculateToll());
        }
        System.out.println("Total collected: $" + totalCollected);
    }
}