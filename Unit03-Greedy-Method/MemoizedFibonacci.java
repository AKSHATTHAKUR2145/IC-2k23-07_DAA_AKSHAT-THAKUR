import java.util.Arrays;

public class MemoizedFibonacci {
    // Memoization (top-down DP): O(n) time and O(n) space.
    public static long fibonacci(int n, long[] memo) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];

        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);

        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n, memo));
    }
}
