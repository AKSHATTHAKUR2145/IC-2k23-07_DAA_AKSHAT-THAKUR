
public class ComplexityAnalysis {

    public static int linearSearchSteps(int[] arr, int key) {
        int comparisons = 0;

        for (int x : arr) {
            comparisons++;

            if (x == key) {
                return comparisons;
            }
        }

        return comparisons;
    }

    public static int binarySearchSteps(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;

            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return comparisons;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {

        int n = 1024;
        int[] arr = new int[n];

        // Initialize sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.println("Input Size (N) = " + n);

        System.out.printf("%-20s %-12s %-15s %-12s%n",
                "Algorithm", "Best Case", "Average Case", "Worst Case");

        System.out.println("--------------------------------------------------------");

        System.out.printf("%-20s %-12d %-15d %-12d%n",
                "Linear Search",
                linearSearchSteps(arr, arr[0]),
                linearSearchSteps(arr, arr[n / 2]),
                linearSearchSteps(arr, -1));

        System.out.printf("%-20s %-12d %-15d %-12d%n",
                "Binary Search",
                binarySearchSteps(arr, arr[(n - 1) / 2]),
                binarySearchSteps(arr, arr[n / 3]),
                binarySearchSteps(arr, -1));
    }
}
