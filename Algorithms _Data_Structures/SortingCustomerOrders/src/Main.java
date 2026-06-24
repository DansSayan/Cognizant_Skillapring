import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 45.00),
            new Order("O003", "Charlie", 500.00),
            new Order("O004", "David", 120.75)
        };

        Order[] ordersForQuick = Arrays.copyOf(ordersForBubble, ordersForBubble.length);

        System.out.println("Bubblw Sort:-");
        BubbleSort.bubblesort(ordersForBubble);
        for (Order o : ordersForBubble) System.out.println(o);

        System.out.println("\nQuick Sort:-");
        QuickSort.quicksort(ordersForQuick, 0, ordersForQuick.length - 1);
        for (Order o : ordersForQuick) System.out.println(o);
    }
}
