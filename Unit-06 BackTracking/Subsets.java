import java.util.*;

public class Subsets {
    public static List<List<Integer>> generate(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] arr, int index, List<Integer> current,
                                  List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            backtrack(arr, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
