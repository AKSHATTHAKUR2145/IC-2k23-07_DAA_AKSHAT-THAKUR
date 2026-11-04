import java.util.Arrays;

public class MaxMin {
    static class Pair {
        int min, max;
        Pair(int min, int max) { this.min = min; this.max = max; }
    }

    // Divide-and-conquer maximum and minimum.
    public static Pair findMinMax(int[] a, int left, int right) {
        if (left == right) return new Pair(a[left], a[left]);

        if (right == left + 1) {
            if (a[left] < a[right]) return new Pair(a[left], a[right]);
            return new Pair(a[right], a[left]);
        }

        int mid = left + (right - left) / 2;
        Pair p1 = findMinMax(a, left, mid);
        Pair p2 = findMinMax(a, mid + 1, right);

        return new Pair(Math.min(p1.min, p2.min), Math.max(p1.max, p2.max));
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 19, -3, 8, 25, 2};
        Pair result = findMinMax(arr, 0, arr.length - 1);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Minimum = " + result.min);
        System.out.println("Maximum = " + result.max);
    }
}
