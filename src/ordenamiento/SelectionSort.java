package ordenamiento;

import java.util.Comparator;

public class SelectionSort {

    public static <T> SortStats sort(T[] arr, Comparator<T> comp) {
        SortStats stats = new SortStats();
        long start = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                stats.comparisons++;

                if (comp.compare(arr[j], arr[min]) < 0) {
                    min = j;
                }
            }

            if (min != i) {
                T temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                stats.swaps++;
            }
        }

        stats.timeMs = System.currentTimeMillis() - start;
        return stats;
    }
}
