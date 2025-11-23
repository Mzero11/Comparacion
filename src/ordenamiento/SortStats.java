package ordenamiento;

public class SortStats {
    public int comparisons;
    public int swaps;
    public long timeMs;

    public SortStats() {
        this.comparisons = 0;
        this.swaps = 0;
        this.timeMs = 0;
    }

    public SortStats(int comparisons, int swaps, long timeMs) {
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.timeMs = timeMs;
    }
}

