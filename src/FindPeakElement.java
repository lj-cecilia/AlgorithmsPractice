//time O(logn)
//space O(1)
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length -1] > nums[nums.length -2]) return nums.length -1;

        int l = 1;
        int h = nums.length - 2;
        while (l <= h) {
            int m = l + (h - l)/2;
            //local max
            if (nums[m] > nums[m-1] && nums[m] > nums[m + 1]) return m;
                //
            else if (nums[m] < nums[m-1]) h = m - 1;
            else if (nums[m] < nums[m+1]) l = m + 1;
        }
        return -1;
    }
}
// Because the question precondition is nums[0] and nums[n] are assumed as infinite,
// then both of the starting and ending are regarded as an ascending line,
// there must be a peak point.
// If nums[mid] > nums[mid+1], then we know there must be a peak in [left, mid]
// (mid still may be a peak element),
// otherwise the other part of the line must have a peak point.
// In another way, binary search means you have a condition can discard half of the searching range.
// This case satisfies the condition, so we can use BS.
