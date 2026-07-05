public class Main {
    public static void main(String[] args) {
        PaymentMethod googlePay = new GooglepayPayment();
        PaymentMethod paypal = new PaypalPayment();

        Payment payment1 = new Payment(googlePay);
        payment1.processPayment(); // Output: Payment done using Google Pay

        Payment payment2 = new Payment(paypal);
        payment2.processPayment(); // Output: Payment done using Paypal
    }

}
