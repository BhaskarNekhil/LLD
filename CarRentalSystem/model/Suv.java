package CarRentalSystem.model;
import CarRentalSystem.enums.*;
public class Suv extends Vehicle{
   

    public Suv(String licensePlate, double pricePerHour, double pricePerKm) {
        super(licensePlate, pricePerHour, pricePerKm,VehicleType.SUV);
       
    }

}
