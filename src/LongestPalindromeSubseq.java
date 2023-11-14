class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        int[][] memo = new int[l + 1][l + 1];
        char[] arr = s.toCharArray();
        for (int i = 0; i < 0; i++) {
            memo[0][i] = 1;
            memo[i][0] = 1;
        }

        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (arr[i - 1] == arr[l - j]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                }
                else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[l][l];
    }
}