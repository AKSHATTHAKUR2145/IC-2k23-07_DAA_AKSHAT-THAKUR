import java.util.*;

public class LongestIncreasingSubsequence {
    public static List<Integer> find(int[] arr) {
        if (arr.length == 0) return new ArrayList<>();

        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int best = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }

        for (int i = 1; i < n; i++)
            if (dp[i] > dp[best]) best = i;

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = best; i != -1; i = parent[i]) result.addFirst(arr[i]);
        return result;
    }
}
