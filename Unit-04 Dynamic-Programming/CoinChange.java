import java.util.*;

public class CoinChange {
    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int value = 1; value <= amount; value++)
            for (int coin : coins)
                if (coin <= value)
                    dp[value] = Math.min(dp[value], dp[value - coin] + 1);

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
