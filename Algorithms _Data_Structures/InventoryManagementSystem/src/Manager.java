import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> inventory = new HashMap<>();

    public void ADD(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product ID " + product.getProductId() + " already exists!");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Added: " + product.getProductName());
        }
    }

    public void UPDATE(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product.getProductName());
        } else {
            System.out.println("Product ID " + productId + " not found!");
        }
    }

    public void DELETE(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Deleted: " + removedProduct.getProductName());
        } else {
            System.out.println("Product ID " + productId + " not found!");
        }
    }

    public void DISPLAY() {
        System.out.println("Items in Inventory:-");
        if (inventory.isEmpty()) 
            System.out.println("No items in Inventory");
        else {
            System.out.printf("%-8s | %-30s | %-8s | %-10s%n", "ID", "Name", "Qty", "Price");
            System.out.println("---------|--------------------------------|----------|----------");
            for (Product p : inventory.values()) 
                System.out.printf("%-8s | %-30s | %-8d | $%-9.2f%n", p.getProductId(), p.getProductName(), p.getQuantity(), p.getPrice());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Manager inventory = new Manager();

        inventory.ADD(new Product("P101", "Gaming Mouse", 150, 49.99));
        inventory.ADD(new Product("P102", "Wireless Keyboard", 80, 89.50));
        inventory.ADD(new Product("P103", "4K Monitor", 25, 349.99));
        inventory.DISPLAY();

        inventory.UPDATE("P102", 130, 84.99); 
        inventory.DISPLAY();

        inventory.DELETE("P101");
        inventory.DISPLAY();
    }
}