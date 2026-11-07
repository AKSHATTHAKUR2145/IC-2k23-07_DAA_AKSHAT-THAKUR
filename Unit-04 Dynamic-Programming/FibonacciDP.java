public class FibonacciDP {
    public static long memoized(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        Long[] memo = new Long[n + 1];
        return solve(n, memo);
    }

    private static long solve(int n, Long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != null) return memo[n];
        return memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
    }

    public static long tabulated(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;

        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
