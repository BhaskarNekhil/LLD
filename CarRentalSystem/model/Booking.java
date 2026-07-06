package CarRentalSystem.model;
import CarRentalSystem.enums.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
public class Booking {

    private String bookingId;
    private User user;
    private Vehicle vehicle;
    private Branch pickupBranch;
    private Branch dropBranch;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status = BookingStatus.CREATED;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private double amount;

    public Booking(String bookingId, User user, Vehicle vehicle,
                   Branch pickupBranch, Branch dropBranch,
                   LocalDateTime startTime, LocalDateTime endTime,
                   BookingStatus status, PaymentStatus paymentStatus,
                   double amount) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.pickupBranch = pickupBranch;
        this.dropBranch = dropBranch;
        this.startTime = startTime;
        this.endTime = endTime;
        if (status != null) {
            this.status = status;
        }
        if (paymentStatus != null) {
            this.paymentStatus = paymentStatus;
        }
        this.amount = amount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Branch getPickupBranch() {
        return pickupBranch;
    }

    public void setPickupBranch(Branch pickupBranch) {
        this.pickupBranch = pickupBranch;
    }

    public Branch getDropBranch() {
        return dropBranch;
    }

    public void setDropBranch(Branch dropBranch) {
        this.dropBranch = dropBranch;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM h:mm a yyyy", Locale.ENGLISH);
        return "\n" +
                "Booking ID: " + bookingId + "\n" +
                "User: " + (user != null ? user.getName() : "N/A") + "\n" +
                "Pickup Time: " + startTime.format(formatter) + "\n" +
                "Drop Time: " + endTime.format(formatter) + "\n" +
                "Pickup Location: " + (pickupBranch != null ? pickupBranch.getCity() : "N/A") + "\n" +
                "Drop Location: " + (dropBranch != null ? dropBranch.getCity() : "N/A") + "\n" +
                "Vehicle Type: " + (vehicle != null ? vehicle.getType() : "N/A") + "\n" +
                "Vehicle Number Plate: " + (vehicle != null ? vehicle.getLicensePlate() : "N/A") + "\n" +
                "Amount: $" + String.format("%.2f", amount) + "\n" +
                "Status: " + status + "\n";
    }
}
