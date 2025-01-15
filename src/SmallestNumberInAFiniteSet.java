//the core of the problem is to use an int to keep track of the smallest value
//and use the priorityqueue to add value when there is even smaller value

import java.util.PriorityQueue;

public class SmallestNumberInAFiniteSet {
    class SmallestInfiniteSet {
        PriorityQueue<Integer> q;
        int smallest;

        public SmallestInfiniteSet() {
            q = new PriorityQueue<>();
            smallest = 1;
        }

        public int popSmallest() {
            //if minHeap is not empty, then remove directly
            if (!q.isEmpty()) return q.poll();
            //if minHeap is empty, return the smallest value manually
            smallest++;
            return smallest - 1;
        }

        public void addBack(int num) {
            if (num < smallest && !q.contains(num)) q.add(num);
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
