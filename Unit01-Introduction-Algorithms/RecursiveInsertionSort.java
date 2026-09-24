package Unit01_Introduction_Algorithms.Sorting;

public class RecursiveInsertionSort {
    public static void sort(int[] arr) {
        sort(arr, arr.length);
    }

    private static void sort(int[] arr, int n) {
        if (n <= 1) return;

        sort(arr, n - 1);

        int key = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}