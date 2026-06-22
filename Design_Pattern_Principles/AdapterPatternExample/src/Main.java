public class Main {
    public static void main (String[] args) {
        PaypalGateway paypal = new PaypalGateway();
        GPayGateway gpay = new GPayGateway();

        PaymentProcessor paypalAdapter = new Adapter_PayPal(paypal);
        PaymentProcessor gpayAdapter = new Adapter_GPay(gpay);
        
        paypalAdapter.processPayment(100.0);
        gpayAdapter.processPayment(200.0);
    }
}
