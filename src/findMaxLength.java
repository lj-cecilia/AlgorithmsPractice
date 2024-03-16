import java.util.HashMap;
import java.util.Map;

//time O(n)
//space O(n)
class findMaxLength {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0, count = 0;
        for(int i = 0;i < nums.length;i++) {
            count += (nums[i] == 1)?1:-1;
            if(count == 0)
                maxlen = Math.max(maxlen, i+1);
            if(map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else
                map.put(count, i);
        }
        return maxlen;
    }
}