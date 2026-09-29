import java.util.*;

public class FractionalKnapsack {
    public static double maximizeValue(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length) throw new IllegalArgumentException("Array sizes must match");

        Integer[] order = new Integer[weights.length];
        for (int i = 0; i < weights.length; i++) order[i] = i;

        Arrays.sort(order, (a, b) ->
            Double.compare((double) values[b] / weights[b], (double) values[a] / weights[a]));

        double total = 0.0;
        int remaining = capacity;

        for (int i : order) {
            if (weights[i] <= remaining) {
                total += values[i];
                remaining -= weights[i];
            } else {
                total += (double) values[i] * remaining / weights[i];
                break;
            }
        }
        return total;
    }
}
