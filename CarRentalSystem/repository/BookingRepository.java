package CarRentalSystem.repository;
import CarRentalSystem.model.Booking;
import java.util.HashMap;  
import java.util.*; 
public class BookingRepository {
    private final HashMap<String, Booking> bookings;
    public BookingRepository() {
        this.bookings = new HashMap<>();
    }
    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }
    public Booking getBookingById(String bookingId) {
        return bookings.getOrDefault(bookingId, null);
    }
    public void removeBooking(String bookingId) {
        bookings.remove(bookingId);
    }
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }
}
