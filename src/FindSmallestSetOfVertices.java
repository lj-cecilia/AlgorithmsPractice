import java.util.ArrayList;
import java.util.List;

class FindSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> count = new ArrayList<>();
        for (List<Integer> edge : edges) {
            int in = edge.get(1);
            indegree[in]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) count.add(i);
        }
        return count;
    }
}