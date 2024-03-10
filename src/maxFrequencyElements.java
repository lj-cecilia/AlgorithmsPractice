//time O(n)
// space O(n)

import java.util.HashMap;

// class maxFrequencyElements {
//     public int maxFrequencyElements(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int max = 0;
//         int result = 0;
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             max = Math.max(max, map.get(num));
//         }
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             int value = entry.getValue();
//             if (value == max) {
//                 result += max;
//             }
//         }
//         return result;
//     }
// }
class maxFrequencyElements {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == max) {
                result += max;
            }
            else if (map.get(num) > max){
                max = map.get(num);
                result = max;
            }
        }

        return result;
    }
}