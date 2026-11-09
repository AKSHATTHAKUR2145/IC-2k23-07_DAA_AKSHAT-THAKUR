public class KnapsackDecision {
    public static boolean canReachValue(int[] weights, int[] values,
                                        int capacity, int requiredValue) {
        int n = weights.length;
        boolean[][] dp = new boolean[capacity + 1][requiredValue + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                for (int v = requiredValue; v >= values[i]; v--) {
                    dp[w][v] |= dp[w - weights[i]][v - values[i]];
                }
            }
        }
        return dp[capacity][requiredValue];
    }
}
