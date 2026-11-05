import java.util.Arrays;

public class TravellingSalesmanDP {
    // Held-Karp bitmask DP. Start and finish at vertex 0.
    // Time: O(n^2 * 2^n), Space: O(n * 2^n)
    public static int tsp(int[][] cost) {
        int n = cost.length;
        if (n == 1) return 0;

        int states = 1 << n;
        final int INF = 1_000_000_000;
        int[][] dp = new int[states][n];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[1][0] = 0; // only city 0 visited

        for (int mask = 1; mask < states; mask++) {
            if ((mask & 1) == 0) continue; // all states must include city 0

            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 || dp[mask][u] == INF) continue;

                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) == 0) {
                        int nextMask = mask | (1 << v);
                        dp[nextMask][v] = Math.min(dp[nextMask][v],
                                dp[mask][u] + cost[u][v]);
                    }
                }
            }
        }

        int fullMask = states - 1;
        int answer = INF;
        for (int last = 1; last < n; last++)
            answer = Math.min(answer, dp[fullMask][last] + cost[last][0]);

        return answer;
    }

    public static void main(String[] args) {
        int[][] cost = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Minimum TSP tour cost = " + tsp(cost));
    }
}
