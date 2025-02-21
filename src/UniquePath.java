//time O(mn)
//space O(mn)

class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] prev = new int[m][n];
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) prev[i][j] = 1;
                else prev[i][j] = prev[i - 1][j] + prev[i][j - 1];
            }
        }
        return prev[m - 1][n - 1];
    }
}