//brute force time O(n^2) space O(n)
// class Solution {
//     public List<List<Integer>> findMatrix(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int max = 0;
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             max = Math.max(max, map.get(num));
//         }

//         List<List<Integer>> list = new ArrayList<>();
//         for (int i = 0; i < max; i++) {
//             list.add(new ArrayList<>());
//         }

import java.util.ArrayList;
import java.util.List;

//         for (int key : map.keySet()) {
//             int val = map.get(key);
//             for (int i = 0; i < val; i++) {
//                 list.get(i).add(key);
//             }
//         }
//         return list;
//     }
// }
//optimized time O(n) space O(n)
class FindMatrix {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] count = new int[nums.length + 1];
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            count[num]++;
            if (result.size() < count[num]) {
                result.add(new ArrayList<>());
            }
            result.get(count[num] - 1).add(num);
        }
        return result;
    }
}