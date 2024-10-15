//time O(n)
//space O(1)
//sliding window approach, j increment and if meet 0, increment zero
//move i until the zero <= 1
class LongestSubarrayOf1AfterDeletion {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int count = 0;
        int zero = 0;
        while (j < nums.length) {
            if (nums[j] == 0) zero++;
            while (zero > 1) {
                if (nums[i] == 0) {
                    zero--;
                }
                i++;
            }
            count = Math.max(count, j - i);
            j++;
        }
        return count;
    }
}