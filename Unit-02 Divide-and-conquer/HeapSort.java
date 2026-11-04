import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] a) {
        int n = a.length;

        // Build max heap.
        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);

        // Move max element to the end, then restore heap.
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    private static void heapify(int[] a, int size, int root) {
        int largest = root;
        int left = 2 * root + 1, right = 2 * root + 2;

        if (left < size && a[left] > a[largest]) largest = left;
        if (right < size && a[right] > a[largest]) largest = right;

        if (largest != root) {
            swap(a, root, largest);
            heapify(a, size, largest);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After sorting:  " + Arrays.toString(arr));
    }
}
