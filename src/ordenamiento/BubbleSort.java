package ordenamiento;

import java.util.Comparator;

public class BubbleSort {

    public static <T> SortStats sort(T[] arr, Comparator<T> comp) {
        SortStats stats = new SortStats();
        long start = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                stats.comparisons++;

                if (comp.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    stats.swaps++;
                }
            }
        }

        stats.timeMs = System.currentTimeMillis() - start;
        return stats;
    }
}
