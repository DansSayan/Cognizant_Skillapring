class PaypalGateway {
    public void makePayment(double amount) {
        System.out.println("Payment processed via PayPal: " + amount);
    }
}
class GPayGateway {
    public void make_Payment(double amount_) {
        System.out.println("Payment processed via GPay: " + amount_);
    }
}

class Adapter_PayPal implements PaymentProcessor {
    private PaypalGateway paypal;
    public Adapter_PayPal (PaypalGateway paypal) {
        this.paypal = paypal;
    }
    public void processPayment (double amount) {
        paypal.makePayment(amount);
    }
}
class Adapter_GPay implements PaymentProcessor {
    private GPayGateway gpay;
    public Adapter_GPay (GPayGateway gpay) {
        this.gpay = gpay;
    }
    public void processPayment (double amount) {
        gpay.make_Payment(amount);
    }
}