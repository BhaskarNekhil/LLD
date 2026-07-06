package CarRentalSystem.strategy.pricing;
import CarRentalSystem.model.Vehicle;
import java.time.LocalDateTime;
public interface PricingStrategy {
    double calculatePrice(Vehicle vehicle,LocalDateTime startTime, LocalDateTime endTime, double distance);
}
