package CarRentalSystem.strategy.payment;
import CarRentalSystem.model.Booking;
public class WalletPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean processPayment(Booking booking) {
        // Implementation for processing payment using wallet
        System.out.println("Processing wallet payment for booking: " + booking.getBookingId());
        return true; // Assuming payment is successful
    }
    
}
