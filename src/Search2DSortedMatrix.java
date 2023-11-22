class Search2DSortedMatrix {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int i = 0, j = matrix[0].length - 1;
    //     while (i < matrix.length && j >= 0) {
    //         if (matrix[i][j] == target) return true;
    //         else if (matrix[i][j] > target) j--;
    //         else if (matrix[i][j] < target) i++;
    //     }
    //     return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l = 0;
        int h = r * c - 1;
        while (l <= h) {
            int m = l + (h - l)/2;
            int value = matrix[m / c][m % c];
            if (value == target) return true;
            else if (value < target) l = m + 1;
            else if (value > target) h = m - 1;
        }
        return false;
    }
}