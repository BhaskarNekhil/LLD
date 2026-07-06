package CarRentalSystem.model;

import CarRentalSystem.enums.*;
// import java.util.concurrent.atomic.AtomicBoolean;
public abstract class Vehicle {

    private String licensePlate;
    private VehicleStatus status;
    private double pricePerHour;
    private double pricePerKm;
    private VehicleType type;
    private int bookingCount = 0;
    // private final AtomicBoolean isBooked = new AtomicBoolean(false);
    public Vehicle(String licensePlate, double pricePerHour, double pricePerKm, VehicleType type) {
        this.licensePlate = licensePlate;
        this.status = VehicleStatus.AVAILABLE;
        this.pricePerHour = pricePerHour;
        this.pricePerKm = pricePerKm;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public VehicleType getType() {
        return type;
    }

    public int getBookingCount() {
        return bookingCount;
    }

    public void incrementBookingCount() {
        bookingCount++;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}