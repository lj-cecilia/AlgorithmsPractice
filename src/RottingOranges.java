//time O(mn)
//space O(mn)


import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        int days = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        while (!q.isEmpty()) {
            //all the current rotted orange
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] orange = q.remove();
                //get current coordinates
                for (int[] direction : directions) {
                    int x = orange[0] + direction[0];
                    int y = orange[1] + direction[1];
                    //get affected area
                    if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1) {
                        //if is not affected yet, add to queue
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            if (!q.isEmpty()) days++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return days;
    }
}