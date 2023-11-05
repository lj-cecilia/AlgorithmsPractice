//space: O(mn)
//time: O(mn)
class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    memo[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    memo[i][j] = i;
                    continue;
                }
                //if the char is the same, no need for editing
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
                //the char is not the same, then we see which way to convert the string:
                //1. to change substring of word1 to word2
                //2. to change substring of word2 to word1
                //3. build from last string by adding a new char
                else {
                    memo[i][j] = Math.min(memo[i - 1][j - 1], Math.min(memo[i - 1][j], memo[i][j - 1])) + 1;
                }
            }
        }
        return memo[m][n];
    }
}