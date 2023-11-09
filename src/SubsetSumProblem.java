// Java program for the above dynamic programming to solve subset sum problem

import java.io.*;
public class SubsetSumProblem {

    // Check if possible subset with
    // given sum is possible or not
    static int subsetSum(int a[], int n, int sum)
    {
        // Storing the value -1 to the matrix
        int tab[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }

        // If the sum is zero it means
        // we got our expected sum
        if (sum == 0)
            return 1;

        if (n <= 0)
            return 0;

        // If the value is not -1 it means it
        // already call the function
        // with the same value.
        // it will save our from the repetition.
        if (tab[n - 1][sum] != -1)
            return tab[n - 1][sum];

        // If the value of a[n-1] is
        // greater than the sum.
        // we call for the next value
        if (a[n - 1] > sum)
            return tab[n - 1][sum] = subsetSum(a, n - 1, sum);
        else {

            // Here we do two calls because we
            // don't know which value is
            // full-fill our criteria
            // that's why we doing two calls
            if (subsetSum(a, n - 1, sum) != 0 || subsetSum(a, n - 1, sum - a[n - 1]) != 0) {
                return tab[n - 1][sum] = 1;
            }
            else
                return tab[n - 1][sum] = 0;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 5;
        int a[] = { 1, 5, 3, 7, 4 };
        int sum = 12;

        if (subsetSum(a, n, sum) != 0) {
            System.out.println("YES\n");
        }
        else
            System.out.println("NO\n");
    }
}

// A recursive solution for subset sum
//public class SubsetSumProblem {
//
//    // Returns true if there is a subset
//    // of set[] with sum equal to given sum
//    static boolean isSubsetSum(int set[], int n, int sum)
//    {
//        // Base Cases
//        if (sum == 0)
//            return true;
//        if (n == 0)
//            return false;
//
//        // If last element is greater than
//        // sum, then ignore it
//        if (set[n - 1] > sum)
//            return isSubsetSum(set, n - 1, sum);
//
//        // Else, check if sum can be obtained
//        // by any of the following
//        // (a) including the last element
//        // (b) excluding the last element
//        return isSubsetSum(set, n - 1, sum)
//                || isSubsetSum(set, n - 1, sum - set[n - 1]);
//    }
//
//    // Driver code
//    public static void main(String args[])
//    {
//        int set[] = { 3, 34, 4, 12, 5, 2 };
//        int sum = 9;
//        int n = set.length;
//        if (isSubsetSum(set, n, sum) == true)
//            System.out.println("Found a subset"
//                    + " with given sum");
//        else
//            System.out.println("No subset with"
//                    + " given sum");
//    }
//}
//
///* This code is contributed by Rajat Mishra */
//
//

//
//public class SubsetSum {
//    // Returns true if there is a subset of set[]
//    // with a sum equal to the given sum
//    static boolean isSubsetSum(int[] set, int n, int sum) {
//        boolean[] prev = new boolean[sum + 1];
//
//        // If the sum is 0, the answer is true
//        for (int i = 0; i <= n; i++)
//            prev[0] = true;
//
//        // If the sum is not 0 and the set is empty,
//        // the answer is false
//        for (int i = 1; i <= sum; i++)
//            prev[i] = false;
//
//        // curr array to store the current row result generated
//        // with the help of the prev array
//        boolean[] curr = new boolean[sum + 1];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (j < set[i - 1])
//                    curr[j] = prev[j];
//                if (j >= set[i - 1])
//                    curr[j] = prev[j] || prev[j - set[i - 1]];
//            }
//            // now curr becomes prev for (i + 1)th element
//            prev = Arrays.copyOf(curr, curr.length);
//        }
//
//        return prev[sum];
//    }
//
//    // Driver code
//    public static void main(String[] args) {
//        int[] set = { 3, 34, 4, 12, 5, 2 };
//        int sum = 9;
//        int n = set.length;
//        if (isSubsetSum(set, n, sum))
//            System.out.println("Found a subset with the given sum");
//        else
//            System.out.println("No subset with the given sum");
//    }
//}
//// This code is contributed by shivamgupta0987654321
//
