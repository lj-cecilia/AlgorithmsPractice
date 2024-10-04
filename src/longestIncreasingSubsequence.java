//import java.util.Arrays;
//
//class longestIncreasingSubsequence {
//    public int lengthOfLIS(int[] nums) {
//        int l = nums.length;
//        int[] memo = new int[l];
//
//        //smallest increasing subsequence is 1
//        int max = 1;
//        Arrays.fill(memo, 1);
//
//        for (int i = 0; i < l; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    memo[i] = Math.max(memo[i], memo[j] + 1);
//                    max = Math.max(memo[i], max);
//                }
//            }
//        }
//        return max;
//    }
//}

import java.util.Arrays;

//time O(n^2) for the nested for and while loops
//space O(n) for the extra index array
class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] index = new int[l];
        Arrays.fill(index, 1);
        int result = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    index[i] = Math.max(index[i], index[j] + 1);
                }
            }
        }
        for (int i : index) {
            result = Math.max(result, i);
        }
        return result;
    }
}