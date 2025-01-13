//time O(nlogn)
//space O(n)

import java.util.PriorityQueue;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) q.remove();
        }
        return q.remove();
    }
}