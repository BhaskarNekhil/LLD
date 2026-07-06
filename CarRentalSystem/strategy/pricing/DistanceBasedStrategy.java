package CarRentalSystem.strategy.pricing;
import CarRentalSystem.model.Vehicle;
import java.time.LocalDateTime;
public class DistanceBasedStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, double distance) {
        // Implementation for distance-based pricing strategy
        return vehicle.getPricePerKm() * distance;
    }
    
}
