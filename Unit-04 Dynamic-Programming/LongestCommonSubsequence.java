public class LongestCommonSubsequence {
    public static String find(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++)
                dp[i][j] = a.charAt(i - 1) == b.charAt(j - 1)
                    ? dp[i - 1][j - 1] + 1
                    : Math.max(dp[i - 1][j], dp[i][j - 1]);

        StringBuilder result = new StringBuilder();
        int i = a.length(), j = b.length();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                result.append(a.charAt(i - 1));
                i--; j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) i--;
            else j--;
        }
        return result.reverse().toString();
    }
}
