import java.util.ArrayList;
import java.util.List;

class CourseSchedule {
    public boolean dfs(int i, boolean[] visited, boolean[] track, ArrayList<List<Integer>> list) {
        //not visit in this route yet, but it's in the track
        if (track[i]) return true;

        //already visit this, no need to proceed
        if (visited[i]) return false;

        visited[i] = true;
        track[i] = true;
        for (Integer vertex : list.get(i)) {
            if (dfs(vertex, visited, track, list)) return true;
        }
        track[i] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[] visited = new boolean[n];
        boolean[] track = new boolean[n];

        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            list.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (dfs(i, visited, track, list)) return false;
        }
        return true;
    }
}