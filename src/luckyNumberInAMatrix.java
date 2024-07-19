//time O(m * n)
//space O(m + n)
import java.util.ArrayList;
import java.util.List;

class luckyNumberInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Get the indices of all the mins in a row
        for (int i = 0; i < m; i++) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    index = j;
                    min = matrix[i][j];
                }
            }
            list.add(index);
        }

        // Get the indices of all the maxes in a column
        for (int j = 0; j < n; j++) {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > max) {
                    index = i; // Use `j` instead of `i` for row index
                    max = matrix[i][j];
                }
            }
            list.add(index);
        }

        // Check if any min indices match the max indices
        for (int i = 0; i < m; i++) {
            int rowIndex = i;
            int colIndex = list.get(i);
            if (matrix[rowIndex][colIndex] == matrix[list.get(colIndex)][colIndex]) {
                result.add(matrix[rowIndex][colIndex]);
            }
        }
        return result;
    }
}
