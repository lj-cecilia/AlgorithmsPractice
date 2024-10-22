//time O(n)
//space O(n)

import java.util.HashMap;
import java.util.HashSet;

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (!set.add(map.get(num))) return false;
        }
        return true;
    }
}
