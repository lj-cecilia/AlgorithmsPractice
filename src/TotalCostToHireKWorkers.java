//time O(klog candidates)
//space O(n)


import java.util.PriorityQueue;

class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        long result = 0;
        int start = 0;
        int end = costs.length - 1;
        while (k > 0) {
            while (q1.size() < candidates && start <= end) {
                q1.add(costs[start]);
                start++;
            }
            while (q2.size() < candidates && start <= end) {
                q2.add(costs[end]);
                end--;
            }
            int val1 = (q1.size() > 0) ? q1.peek() : Integer.MAX_VALUE;
            int val2 = (q2.size() > 0) ? q2.peek() : Integer.MAX_VALUE;

            if (val1 <= val2) {
                q1.poll();
                result += val1;
            } else {
                q2.poll();
                result += val2;
            }
            k--;
        }
        return result;
    }
}