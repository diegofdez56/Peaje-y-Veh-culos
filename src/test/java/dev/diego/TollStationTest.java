package dev.diego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TollStationTest {

    private TollStation tollStation;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("Main Toll Station", "City X");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCar() {
        Vehicle car = new Car("ABC123");
        assertEquals(100.0, car.calculateToll(), 0.01);
    }

    @Test
    public void testMotorcycle() {
        Vehicle motorcycle = new Motorcycle("XYZ987");
        assertEquals(50.0, motorcycle.calculateToll(), 0.01);
    }

    @Test
    public void testTruck() {
        Vehicle truck = new Truck("TRK456", 4);
        assertEquals(200.0, truck.calculateToll(), 0.01);
    }

    @Test
    public void testRegisterCarAtTollStation() {
        Vehicle car = new Car("CAR111");
        tollStation.registerVehicle(car);
        assertEquals(100.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testRegisterMotorcycleAtTollStation() {
        Vehicle motorcycle = new Motorcycle("MOTO222");
        tollStation.registerVehicle(motorcycle);
        assertEquals(50.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testRegisterTruckAtTollStation() {
        Vehicle truck = new Truck("TRK333", 2);
        tollStation.registerVehicle(truck);
        assertEquals(100.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testRegisterMultipleVehicles() {
        Vehicle car = new Car("CAR111");
        Vehicle motorcycle = new Motorcycle("MOTO222");
        Vehicle truck = new Truck("TRK333", 4);

        tollStation.registerVehicle(car);
        tollStation.registerVehicle(motorcycle);
        tollStation.registerVehicle(truck);

        assertEquals(100.0 + 50.0 + (50.0 * 4), tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testTotalCollectedInitially() {
        assertEquals(0.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testTotalCollectedAfterNoRegistrations() {
        assertEquals(0.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testTollCollectionWithMultipleTrucks() {
        Vehicle truck1 = new Truck("TRK111", 3);
        Vehicle truck2 = new Truck("TRK222", 5);
        Vehicle truck3 = new Truck("TRK333", 2);

        tollStation.registerVehicle(truck1);
        tollStation.registerVehicle(truck2);
        tollStation.registerVehicle(truck3);

        assertEquals(3 * 50.0 + 5 * 50.0 + 2 * 50.0, tollStation.getTotalCollected(), 0.01);
    }

    @Test
    public void testTollStationName() {
        assertEquals("Main Toll Station", tollStation.getName());
    }

    @Test
    public void testTollStationCity() {
        assertEquals("City X", tollStation.getCity());
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }
}