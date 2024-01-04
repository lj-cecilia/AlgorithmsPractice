
// class MinOperations {
//     public int minOperations(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         int operations = 0;
//         for (int key : map.keySet()) {
//             if (map.get(key) == 1) {
//                 return -1;
//             }
//             while (map.get(key) > 0) {
//                 if (map.get(key) % 3 == 0) {
//                     map.put(key, map.get(key) - 3);
//                     operations++;
//                 } else if (map.get(key) % 3 == 1) {
//                     map.put(key, map.get(key) - 4);
//                     operations+=2;
//                 } else if (map.get(key) % 3 == 2) {
//                     map.put(key, map.get(key) - 2);
//                     operations++;
//                 }
//             }
//         }
//         return operations;
//     }
// }

import java.util.HashMap;
import java.util.Map;

class MinOperations {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (int value : map.values()) {
            if (value == 1) {
                return -1;
            }
            //get rid of as many 3's as possible
            //if there is anything left, use ceiling for 1 operation to remove the last 2 number
            operations += (Math.ceil((double)value / 3));
        }
        return operations;
    }
}