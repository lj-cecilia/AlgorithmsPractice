//time O(nlogn)
//space O(n)

import java.util.Collections;
import java.util.PriorityQueue;

class MaximizeHappinessOfSelectedChildren {
    public long MaximizeHappinessOfSelectedChildren(int[] happiness, int k) {
        long result = 0;
        int decrement = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int happy : happiness) {
            q.add(happy);
        }
        for (int i = 0; i < k; i++) {
            int num = q.poll();
            num -= decrement;
            result += (num > 0)? num : 0;
            decrement++;
        }
        return result;
    }
}