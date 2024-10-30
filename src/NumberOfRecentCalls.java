//time O(1); at most 3000 iterations
//space O(1); at most 3000 integers in the list


import java.util.LinkedList;
import java.util.Queue;

class NumberOfRecentCalls {
    Queue<Integer> q;
    public NumberOfRecentCalls() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) q.remove();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */