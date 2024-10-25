//time O(n^2)
//space O(n)


import java.util.HashMap;

class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int result = 0;
        HashMap<String, Integer> row = new HashMap<>();
        HashMap<String, Integer> col = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j] + ".");
            }
            row.put(sb.toString(), row.getOrDefault(sb.toString(), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i] + ".");
            }
            col.put(sb.toString(), col.getOrDefault(sb.toString(), 0) + 1);
        }

        for (String s : row.keySet()) {
            if (col.containsKey(s)) result += (row.get(s) * col.get(s));
        }
        return result;
    }
}