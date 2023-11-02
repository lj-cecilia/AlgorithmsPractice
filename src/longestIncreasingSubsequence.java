import java.util.Arrays;

class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] memo = new int[l];

        //smallest increasing subsequence is 1
        int max = 1;
        Arrays.fill(memo, 1);

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    max = Math.max(memo[i], max);
                }
            }
        }
        return max;
    }
}