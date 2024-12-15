//time O(n)
//space O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ReorderRoutesToMakeCityZero {
    public int minReorder(int n, int[][] connections) {

        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < connections.length; i++) {
            list.get(connections[i][0]).add(connections[i][1]);
            list.get(connections[i][1]).add(-connections[i][0]);
        }

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.remove();
            for (int vertex : list.get(Math.abs(current))) {
                if (!visited[Math.abs(vertex)]) {
                    q.add(vertex);
                    visited[Math.abs(vertex)] = true;
                    if (vertex > 0) count++;
                }
            }
        }
        return count;

    }
}