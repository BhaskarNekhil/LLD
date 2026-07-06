package CarRentalSystem.factory;
import CarRentalSystem.enums.VehicleType;
import CarRentalSystem.model.*;
public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String licensePlate, double pricePerHour, double pricePerKm) {
        switch (vehicleType) {
            case SEDAN:
                return new Sedan(licensePlate, pricePerHour, pricePerKm);
            case SUV:
                return new Suv(licensePlate, pricePerHour, pricePerKm);
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }
    }
}
