package Unit05_Traversal_and_Search.Searching;

public class RecursiveBinarySearch {
    public static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        if (arr[mid] < target) {
            return search(arr, target, mid + 1, right);
        }
        return search(arr, target, left, mid - 1);
    }
}