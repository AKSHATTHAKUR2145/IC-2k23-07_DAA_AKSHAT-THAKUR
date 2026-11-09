import java.util.*;

public class Permutations {
    public static List<List<Integer>> generate(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, boolean[] used, List<Integer> current,
                                  List<List<Integer>> result) {
        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(arr[i]);
                backtrack(arr, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
