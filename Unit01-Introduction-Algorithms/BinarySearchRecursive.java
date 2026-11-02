
public class BinarySearchRecursive {

    // Recursive Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    public static int binarySearch(int[] arr, int low, int high, int key) {

        // Base case: Element not found
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Element found
        if (arr[mid] == key) {
            return mid;
        }

        // Search right half
        if (arr[mid] < key) {
            return binarySearch(arr, mid + 1, high, key);
        }

        // Search left half
        return binarySearch(arr, low, mid - 1, key);
    }

    public static void main(String[] args) {

        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        int key = 23;

        int result = binarySearch(arr, 0, arr.length - 1, key);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
