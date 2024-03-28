//time O(n)
//space O(n)

//two pointers sliding window approach
import java.util.HashMap;
import java.util.Map;

class maxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        while (right < nums.length) {
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.get(num) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}