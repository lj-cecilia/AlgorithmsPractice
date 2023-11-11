// 2D DP
// O(mn) for both space and time complexity
class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3) return false;
        if (l1 == 0) return s2.equals(s3);
        if (l2 == 0) return s1.equals(s3);

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        boolean[][] memo = new boolean[l1 + 1][l2 + 1];
        memo[0][0] = true;
        for (int i = 1; i <= l1; i++)
            memo[i][0] = (memo[i - 1][0] && arr1[i - 1] == arr3[i - 1]);
        for (int j = 1; j <= l2; j++)
            memo[0][j] = (memo[0][j - 1] && arr2[j - 1] == arr3[j - 1]);

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                memo[i][j] =
                        //take char from s1
                        (memo[i - 1][j] && arr1[i - 1] == arr3[i + j - 1])
                                //take char from s2
                                || (memo[i][j - 1] && arr2[j - 1] == arr3[i + j - 1]);
            }
        }
        return memo[l1][l2];
    }
}