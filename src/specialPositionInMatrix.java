// brute force with O(m * n * (m + n))
// class specialPositionInMatrix {
//     public int numSpecial(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int count = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 1) {
//                     count += checkValid(i, j, mat);

//                 }
//             }
//         }
//         return count;
//     }

//     public int checkValid(int a, int b, int[][] mat) {
//         for (int i = 0; i < mat.length; i++) {
//             if (i != a && mat[i][b] == 1) return 0;
//         }

//         for (int j = 0; j < mat[0].length; j++) {
//             if (j != b && mat[a][j] == 1) return 0;
//         }
//         return 1;
//     }
// }

//Optimized by keeping track of the information about current row and current column
//O(m * n)
class specialPositionInMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((mat[i][j] == 1) &&
                        rowCount[i] == 1 &&
                        colCount[j] == 1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
