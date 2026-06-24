public class QuickSort {
    public static void quicksort(Order[] orders, int l, int r) {
        if (l<r) {
            int j = Partition(orders, l, r);
            quicksort(orders, l, j-1);
            quicksort(orders, j+1, r);
        }
    }

    private static int Partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice(); 
        int i = low - 1;
        int j = low; 
        while (j < high) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
            j++; 
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;
        return i+1;
    }
}
