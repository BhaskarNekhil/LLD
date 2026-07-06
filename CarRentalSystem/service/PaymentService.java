package CarRentalSystem.service;
import CarRentalSystem.model.Booking;
import CarRentalSystem.strategy.payment.PaymentStrategy;
import CarRentalSystem.enums.PaymentStatus;
public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(Booking booking) {
        boolean success = paymentStrategy.processPayment(booking);
        if (success) {
            // System.out.println("Payment successful for booking: " + booking.getBookingId());
            booking.setPaymentStatus(PaymentStatus.SUCCESS);
          
        } else {
            // System.out.println("Payment failed for booking: " + booking.getBookingId());
            booking.setPaymentStatus(PaymentStatus.FAILED);
            
        }
        return success;
    }
}
