class countSubIslands {
    int valid = 0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if (grid2[i][j] == 1) { more efficient but make less sense logically
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    valid = 1;
                    dfs(grid1, grid2, i, j);
                    count += valid;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;
        //if not an island of grid2 or index out of bound
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) return;

        //now visited this island of grid2, mark it as 0
        grid2[i][j] = 0;
        //if it's island of grid2 but not island of grid1, then mark the valid as 0
        if (grid1[i][j] == 0) valid = 0;
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }
}