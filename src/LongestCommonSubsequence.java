////improve space complexity, use 2 arrays of size m or n
////instead of mn size matrix
//class LongestCommonSubsequence {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        int[][] matrix = new int[m + 1][n + 1];
//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                if (i == 0 || j == 0) {
//                    matrix[i][j] = 0;
//                }
//                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
//                }
//                else matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
//            }
//        }
//        return matrix[m][n];
//    }
//}

//time O(mn)
//space O(mn)

//logic: in the matrix, the current LCS is related to the previous three directions LCS
//if we find a match, we should add from diagonal, if no match, then take the max of the top and left
//class LongestCommonSubsequence {
//    public int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        int[][] sequence = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    sequence[i][j] = sequence[i - 1][j - 1] + 1;
//                }
//                else sequence[i][j] = Math.max(sequence[i - 1][j], sequence[i][j - 1]);
//            }
//        }
//        return sequence[m][n];
//    }
//}

//optimized space solution

//time O(mn)
//space O(n)

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] current = new int[n + 1];
        int[] prev = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    current[j] = prev[j - 1] + 1;
                }
                else current[j] = Math.max(current[j - 1], prev[j]);
            }
            prev = current.clone();
        }
        return current[n];
    }
}
