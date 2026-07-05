public class GooglepayPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Payment done using Google Pay");
    }
}
