import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {
    public static Product linearSearch(Product[] products, String targetId) {
        for (int i=0; i<products.length; i++) 
            if (products[i].getProductId().equals(targetId)) 
                return products[i]; 
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            int comparison = sortedProducts[mid].getProductId().compareTo(targetId);
            if (comparison == 0) return sortedProducts[mid];
            else if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] collection = {
            new Product("P503", "Wireless Earbuds", "Electronics"),
            new Product("P101", "Gaming Laptop", "Computers"),
            new Product("P809", "Ergonomic Desk Chair", "Furniture"),
            new Product("P202", "Smartphone Case", "Accessories"),
            new Product("P444", "Coffee Maker", "Appliances")
        };

        String searchId = "P202";

        System.out.println("Linear Search:-");
        Product result1 = linearSearch(collection, searchId);
        System.out.println("Search Result: " + (result1 != null ? result1 : "Not Found"));

        Product[] sorted = Arrays.copyOf(collection, collection.length);
        Arrays.sort(sorted, Comparator.comparing(Product::getProductId));
        System.out.println("\nSorted Collection:-");
        for (Product p : sorted) System.out.println("  " + p);
        
        System.out.println("\nBinary Search:-");
        Product result2 = binarySearch(sorted, searchId);
        System.out.println("Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}