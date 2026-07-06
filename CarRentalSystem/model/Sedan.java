package CarRentalSystem.model;
import CarRentalSystem.enums.*;
public class Sedan extends Vehicle {
  

     public Sedan(String licensePlate, double pricePerHour, double pricePerKm) {
        super(licensePlate, pricePerHour, pricePerKm,VehicleType.SEDAN);
       
    }

    
}
