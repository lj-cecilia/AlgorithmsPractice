//time O(n^2)
//space O(n)

class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int l = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[l];
        for (int i = 0; i < l; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[current][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
        return;
    }
}