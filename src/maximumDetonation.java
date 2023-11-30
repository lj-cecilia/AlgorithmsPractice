import java.util.ArrayList;
import java.util.List;

class maximumDetonation {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r1 = bombs[i][2];
            lists.add(new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                double x2 = bombs[j][0];
                double y2 = bombs[j][1];
                int r2 = bombs[j][2];
                double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                if (distance <= r1) lists.get(i).add(j);
            }
        }
        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, 1 + dfs(lists, i, new boolean[bombs.length]));
        }
        return max;
    }

    public int dfs(List<List<Integer>> lists, int index, boolean[] visited) {
        int count = 0;
        visited[index] = true;
        List<Integer> list = lists.get(index);
        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            if (!visited[next]) count += 1 + dfs(lists, next, visited);
        }
        return count;
    }
}