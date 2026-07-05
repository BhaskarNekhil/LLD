package model;
import enums.VehicleType;
public class Truck extends Vehicle {
    public Truck(String vehicleNumber){
        super(vehicleNumber, VehicleType.TRUCK);
    }
}