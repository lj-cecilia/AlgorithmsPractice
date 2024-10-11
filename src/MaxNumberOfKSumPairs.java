//time O(nlogn)
//space O(1)

import java.util.Arrays;
class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            }
            else if (nums[i] + nums[j] > k) {
                j--;
            }
            else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}