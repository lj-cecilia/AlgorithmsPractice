class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 0 || n == 0 || m < 3 || n < 3) return;
        //check for the first column and last column for connected islands
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfsBoundary(board, i, 0);
            if (board[i][n - 1] == 'O') dfsBoundary(board, i, n - 1);
        }
        //check for the first row and last row for connected islands
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfsBoundary(board, 0, i);
            if (board[m - 1][i] == 'O') dfsBoundary(board, m - 1, i);
        }

        //change all boundaries and its connected island back to letter O
        //mark all the letter O's unconnected to the islands as X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }
    public void dfsBoundary(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;

        board[i][j] = '1';
        dfsBoundary(board, i + 1, j);
        dfsBoundary(board, i - 1, j);
        dfsBoundary(board, i, j + 1);
        dfsBoundary(board, i, j - 1);
    }
}