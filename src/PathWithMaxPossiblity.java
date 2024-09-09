//time O(n * m)
//space O(n)

class PathWithMaxPossiblity {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] distance = new double[n];
        distance[start_node] = 1;
        for (int i = 0; i < n - 1; i++) {
            boolean update = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double value = succProb[j];

                if (distance[u] * value > distance[v]) {
                    distance[v] = distance[u] * value;
                    update = true;
                }

                if (distance[v] * value > distance[u]) {
                    distance[u] = distance[v] * value;
                    update = true;
                }
            }
            if (!update) break;
        }
        return distance[end_node];
    }
}