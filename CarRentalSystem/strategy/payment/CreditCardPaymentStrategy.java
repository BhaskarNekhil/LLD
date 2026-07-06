package CarRentalSystem.strategy.payment;
import CarRentalSystem.model.Booking;
public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(Booking booking) {
        // Implementation for processing payment via credit card
        System.out.println("Processing credit card payment for booking: " + booking.getBookingId());
        return true; // Assuming payment is successful
    }
    
}
