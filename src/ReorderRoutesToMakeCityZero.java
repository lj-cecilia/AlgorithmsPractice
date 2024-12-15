//time O(n)
//space O(n)
import java.util.*;

//class ReorderRoutesToMakeCityZero {
//    public int minReorder(int n, int[][] connections) {
//
//        boolean[] visited = new boolean[n];
//        List<List<Integer>> list = new ArrayList<>();
//        Queue<Integer> q = new LinkedList<>();
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < connections.length; i++) {
//            list.get(connections[i][0]).add(connections[i][1]);
//            list.get(connections[i][1]).add(-connections[i][0]);
//        }
//
//        q.offer(0);
//        visited[0] = true;
//
//        while (!q.isEmpty()) {
//            int current = q.remove();
//            for (int vertex : list.get(Math.abs(current))) {
//                if (!visited[Math.abs(vertex)]) {
//                    q.add(vertex);
//                    visited[Math.abs(vertex)] = true;
//                    if (vertex > 0) count++;
//                }
//            }
//        }
//        return count;
//    }
//}

//memory limit exceeded with adjacency matrix
class ReorderRoutesToMakeCityZeroÏ {
    public int minReorder(int n, int[][] connections) {
        int[][] bi = new int[n][n];
        int[][] one = new int[n][n];
        int count = 0;

        for (int[] connection : connections) {
            int start = connection[0];
            int end = connection[1];
            bi[start][end] = 1;
            bi[end][start] = 1;
            one[start][end] = 1;
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int current = q.remove();
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i) && (bi[current][i] == 1)) {
                    q.add(i);
                    visited.add(i);
                    // if (one[current][i] == 1 && one[i][current] == 0) count++;
                    if (one[current][i] == 1) count++;
                }
            }
        }
        return count;
    }
}

