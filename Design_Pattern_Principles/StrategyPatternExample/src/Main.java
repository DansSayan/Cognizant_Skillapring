public class Main { 
    public static void main(String[] args) {
        PaymentContext cartContext = new PaymentContext();
        double cartTotal = 89.99;

        System.out.println("\nCredit Card:-");
        cartContext.setPaymentStrategy(new CreditCardPayment("John Doe", "1234-5678-9012-3456"));
        cartContext.executePayment(cartTotal);

        System.out.println("\n-------------------------------------------");

        System.out.println("\nPayPal:-");
        cartContext.setPaymentStrategy(new PayPalPayment("johndoe@example.com"));
        cartContext.executePayment(cartTotal); 
    }
}