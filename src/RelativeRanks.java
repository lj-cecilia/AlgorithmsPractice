//time O(nlogn)
//space O(n)

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : score) {
            q.offer(s);
        }

        Map<Integer, String> map = new HashMap<>();
        int n = q.size();
        for (int i = 1; i <= n; i++) {
            if (i == 1) map.put(q.remove(), "Gold Medal");
            else if (i == 2) map.put(q.remove(), "Silver Medal");
            else if (i == 3) map.put(q.remove(), "Bronze Medal");
            else map.put(q.remove(), i + "");
        }

        String[] result = new String[map.size()];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(score[i]);
        }
        return result;
    }
}