//11/27/2023
//time O(n) space O(n)
import java.util.Arrays;

class knightDialer {
    public int knightDialer(int n) {
        int mod = (int)1e9 + 7;
        int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n][10];

        //first row is all 1, for length of 1, we start directly from each number
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : moves[j]) {
                    dp[i][j] += dp[i - 1][next];
                    dp[i][j] %= mod;
                }
            }
        }

        int result = 0;
        for (int count : dp[n - 1]) {
            result += count;
            result %= mod;
        }
        return result;
    }
}