package CarRentalSystem.strategy.pricing;
import CarRentalSystem.model.Vehicle;
import java.time.LocalDateTime;
import java.time.Duration;
public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime, double distance) {
        // Implementation for calculating price based on hourly rate
        long minutes = Duration.between(startTime, endTime).toMinutes();
        double hours = Math.ceil(minutes / 60.0);
        return vehicle.getPricePerHour() * hours;
        
    }
}
