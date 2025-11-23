package ordenamiento;

import java.util.Comparator;

public class InsertionSort {

    public static <T> SortStats sort(T[] arr, Comparator<T> comp) {
        SortStats stats = new SortStats();
        long start = System.currentTimeMillis();

        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                stats.comparisons++;

                if (comp.compare(arr[j], key) > 0) {
                    arr[j + 1] = arr[j];
                    j--;
                    stats.swaps++;
                } else break;
            }

            arr[j + 1] = key;
        }

        stats.timeMs = System.currentTimeMillis() - start;
        return stats;
    }
}
