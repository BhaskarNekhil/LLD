package CarRentalSystem.model;

import CarRentalSystem.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {

    private String id;
    private String city;

    private Map<VehicleType, List<Vehicle>> vehicles = new HashMap<>();

    public Branch(String id, String city) {
        this.id = id;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<VehicleType, List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<VehicleType, List<Vehicle>> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehiclesByType(VehicleType type) {
        return vehicles.getOrDefault(type, new ArrayList<>());
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.computeIfAbsent(vehicle.getType(), k -> new ArrayList<>()).add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        List<Vehicle> list = vehicles.get(vehicle.getType());
        if (list != null) {
            list.remove(vehicle);
        }
    }
}