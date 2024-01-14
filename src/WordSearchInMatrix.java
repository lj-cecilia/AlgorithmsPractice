class WordSearchInMatrix {
    int index = 0;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(0, i, j, word, board)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int index, int i, int j, String word, char[][] board) {
        if (index == word.length()) return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != word.charAt(index)) return false;
        //avoid repetitive use on the same dfs
        board[i][j] = '*';
        boolean result = dfs(index + 1, i - 1, j, word, board) ||
                dfs(index + 1, i + 1, j, word, board)||
                dfs(index + 1, i, j - 1, word, board)||
                dfs(index + 1, i, j + 1, word, board);
        board[i][j] = word.charAt(index);
        return result;
    }
}
