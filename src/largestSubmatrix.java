//11/26/2023
//time O(n^2) space O(1)
import java.util.Arrays;

class largestSubmatrix {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        //modify original matrix, store count of vertical 1's at current index
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) matrix[i][j] = matrix[i - 1][j] + 1;
            }
        }

        for (int[] row : matrix) {
            //simulate the optimal column arrangement
            Arrays.sort(row);
            //check from right to get the max height
            //k is the width that increment as the index progress to left
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; k++, j--) {
                int area = k * row[j];
                max = Math.max(max, area);
            }
        }
        return max;
    }
}