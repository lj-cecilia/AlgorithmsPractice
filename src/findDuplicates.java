import java.util.ArrayList;
import java.util.List;

class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) list.add(num);
            nums[num - 1] *= -1;
        }
        return list;
    }
}