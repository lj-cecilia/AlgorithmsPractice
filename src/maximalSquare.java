//to find max matrix with 1, use this equation to update
//if current position is 1, then we check the top, the left, and the upper-left corner, find the min between then and add 1 as the current grid size
//if any one of the 3 is 0, then our current grid size is 1, containing just just current value
//if all of the 3 are 1 and current is one, then our grid size is 2
//is the min of the above 3 + 1 which is current
class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return 0;

        int max = '0';
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0' && i != 0 && j != 0) {
                    matrix[i][j] = (char) (Math.min(
                            matrix[i - 1][j] - '0',
                            Math.min(matrix[i][j - 1] - '0',
                                    matrix[i - 1][j - 1] - '0')) + 1 + '0');
                }

                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
        return (max - '0') * (max - '0');
    }
}