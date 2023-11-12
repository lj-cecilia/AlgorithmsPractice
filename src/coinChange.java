import java.util.Arrays;

class coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //for each amount, we compute the smallest numbers of coins to get to the amount. do so by examing if this amount is greater than our available coins
            //if yes, then continue to explore the possibility by checking its dp after adding this coin
            //since we build it bottom up, the later can always make use of the dp which are smaller than them
            for (int coin : coins) {
                //the one is the coin we use
                //e.g. dp[7] = 1 + dp[3] if the current coin has value 4
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return (dp[amount] == amount + 1)? -1 : dp[amount];
    }
}
