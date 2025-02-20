//time O(n)
//space O(n)

//n = 1, total = 1;
//n = 1, total = 1;
//n = 2, total = 2;
//n = 3, total = 5;
//n = 4, total = 11
//n = 5, total = 24

//find pattern T(n) = 2 * T(n - 1) + T(n - 3) and then dynamic programming
class DominoAndTrominoTiling {
    public int numTilings(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n];
    }
}