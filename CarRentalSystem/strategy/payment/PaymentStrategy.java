package CarRentalSystem.strategy.payment;
import CarRentalSystem.model.Booking;
public interface PaymentStrategy {
    boolean processPayment(Booking booking);
}
