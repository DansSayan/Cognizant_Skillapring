public class PaymentContext {
    private PaymentStrategy payment_strat;
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.payment_strat = strategy;
    }
    public void executePayment(double amount) { 
        if (payment_strat == null) {
            System.out.println("Error: Please select a payment method first!");
        } else {
            payment_strat.pay(amount); 
        }
    }
}