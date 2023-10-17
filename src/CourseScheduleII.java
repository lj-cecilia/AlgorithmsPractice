import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adjacency list
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int prev = edge[1];
            int curr = edge[0];
            indegree[curr]++;
            list.get(prev).add(curr);
        }
        //bfs
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            //the node that has no indegree are the base requiremments, add to q
            if (indegree[i] == 0) q.add(i);
        }
        //capture all visited vertex in the bfs, serve as index
        int visited = 0;
        //arr to store the order of each vertex to visit
        int[] result = new int[numCourses];
        while (!q.isEmpty()) {
            Integer current = q.poll();
            result[visited++] = current;
            for (Integer vertex : list.get(current)) {
                indegree[vertex]--;
                if (indegree[vertex] == 0) q.add(vertex);
            }
        }
        return visited == numCourses? result : new int[0];
    }
}