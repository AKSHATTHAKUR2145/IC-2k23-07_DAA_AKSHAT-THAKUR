package Unit01_Introduction_Algorithms.Sorting;

public class RecursiveBubbleSort {
    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    private static void sort(int[] arr, int n) {
        if (n <= 1) return;

        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }

        if (swapped) sort(arr, n - 1);
    }
}