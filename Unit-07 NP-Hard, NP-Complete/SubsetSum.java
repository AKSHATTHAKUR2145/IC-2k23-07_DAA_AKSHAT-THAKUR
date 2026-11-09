public class SubsetSum {
    public static boolean exists(int[] arr, int target) {
        return search(arr, 0, target);
    }

    private static boolean search(int[] arr, int index, int target) {
        if (target == 0) return true;
        if (index == arr.length) return false;

        if (search(arr, index + 1, target - arr[index])) return true;
        return search(arr, index + 1, target);
    }
}
