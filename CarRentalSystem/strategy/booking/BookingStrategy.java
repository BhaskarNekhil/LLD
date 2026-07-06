package CarRentalSystem.strategy.booking;
import CarRentalSystem.model.Vehicle;
import java.util.List;
public interface BookingStrategy {
    Vehicle bookVehicle(List<Vehicle> vehicles);
}
