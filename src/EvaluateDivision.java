//time O(N * (V + E))
//space O(V + E)
//for graph creation is O(E), for dfs is O(V + E), for queriers loop is N


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build graph
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] result = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            double val = values[i];
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            map.putIfAbsent(start, new HashMap());
            map.get(start).put(end, val);
            map.putIfAbsent(end, new HashMap());
            map.get(end).put(start, 1/val);
        }

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            double[] arr = {-1.0}; //default -1 if doesn't find
            HashSet<String> visited = new HashSet<>();

            //no such vertex, no dfs
            if (!map.containsKey(start) || !map.containsKey(end)) {
                result[i] = -1;
                continue;
            }
            dfs(map, start, end, visited, arr, 1.0);
            result[i] = arr[0];
        }
        return result;
    }

    public void dfs(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited, double[] arr, double current) {
        //if visited, continue
        if (visited.contains(start)) return;
        //notice we add the start
        visited.add(start);

        //find the end vertex, return
        if (start.equals(end)) {
            arr[0] = current;
            return;
        }
        //on the way to find vertex, loop through the map
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            String newEnd = entry.getKey();
            double nextVal = entry.getValue();
            //The end remains constant, while the start updates as we visit each new node, accumulating the values along the path.
            dfs(map, newEnd, end, visited, arr, current * nextVal);
            //notice here we always update the newEnd
        }
    }
}
//build the graph, map one vertex to a hashmap, and the hashmap map another vertex with value
//go through the queies and fill in answers
//each time use the two vertices in the query to fill in the result array
// a/b = 2
// b/c = 3
// a/c = 6