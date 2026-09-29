import java.util.*;

public class ActivitySelection {
    public static List<Integer> selectActivities(int[] start, int[] finish) {
        if (start.length != finish.length) throw new IllegalArgumentException("Array sizes must match");

        List<Integer> indices = new ArrayList<>();
        Integer[] order = new Integer[start.length];
        for (int i = 0; i < start.length; i++) order[i] = i;

        Arrays.sort(order, Comparator.comparingInt(i -> finish[i]));

        int lastFinish = Integer.MIN_VALUE;
        for (int i : order) {
            if (start[i] >= lastFinish) {
                indices.add(i);
                lastFinish = finish[i];
            }
        }
        return indices;
    }
}
