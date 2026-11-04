import java.util.Arrays;

public class BinarySearch {
    // Returns index of key or -1 if not found. Array must be sorted.
    public static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 12, 18, 25, 31, 42};
        int key = 25;
        System.out.println("Array: " + Arrays.toString(arr));
        int index = search(arr, key);
        System.out.println(index >= 0 ? key + " found at index " + index : key + " not found");
    }
}
