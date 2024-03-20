//time O(n)
//space O(n)

import java.util.PriorityQueue;
class buyChocolate {
    public int buyChoco(int[] prices, int money) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int price : prices) {
            q.add(price);
        }

        int prev = q.poll();
        int curr = 0;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (money - curr - prev >= 0) {
                return money - curr - prev;
            }
            else {
                prev = curr;
            }
        }
        return money;
    }
}