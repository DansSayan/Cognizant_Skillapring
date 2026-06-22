interface PaymentStrategy {
    void pay(double amount); 
}
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (Holder: " + name + ").");
    }
}
class PayPalPayment implements PaymentStrategy { 
    private String email;
    public PayPalPayment(String email) {
        this.email = email;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account (" + email + ").");
    }
}