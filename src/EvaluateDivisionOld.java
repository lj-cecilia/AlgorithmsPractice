//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//
//class EvaluateDivision {
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        //build graph
//        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
//        int index = 0;
//        for (List<String> list : equations) {
//            String first = list.get(0);
//            String second = list.get(1);
//            double value = values[index];
//            map.putIfAbsent(first, new HashMap<>());
//            map.putIfAbsent(second, new HashMap<>());
//            map.get(first).put(second, value);
//            map.get(second).put(first, 1.0 / value);
//            index++;
//        }
//        //build result array
//        double[] result = new double[queries.size()];
//
//        for (int i = 0; i < queries.size(); i++) {
//            String first = queries.get(i).get(0);
//            String second = queries.get(i).get(1);
//            if (!map.containsKey(first) || !map.containsKey(second)) result[i] = -1;
//            else {
//                HashSet<String> set = new HashSet<>();
//                double[] ans = {-1.0}; //for what?
//                double temp = 1.0;
//                dfs(first, second, map, set, ans, temp);
//                result[i] = ans[0];
//            }
//        }
//        return result;
//    }
//
//    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> map, HashSet<String> vis, double[] ans, double temp) {
//        if (vis.contains(node)) return;
//        vis.add(node);
//        if (node.equals(dest)) {
//            ans[0] = temp;
//            return;
//        }
//
//        for (Map.Entry<String, Double> entry : map.get(node).entrySet()) {
//            String next = entry.getKey();
//            double val = entry.getValue();
//            dfs(next, dest, map, vis, ans, temp * val);
//        }
//    }
//}
//
///*Make the graph. For every equation a=nba=nba=nb, add two edges a --n--> b and a <--1/n-- b.
//For each query [c,d][c,d][c,d], check if such nodes even exists in the graph or not. If they don't even exist, there is no path, return -1 (Like in Example 1, x does not exists so return -1 even if we just wanted x / x).
//If both ccc and ddd exists in the graph, traverse the graph to get a path between them, maintaining cost of path as product of weights of edges traversed. If path is found return the product, and if not, then -1.*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class EvaluateDivisonOld {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //edge list with values, can access from start vertex as well as the end vertex
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            map.putIfAbsent(start, new HashMap<>());
            map.putIfAbsent(end, new HashMap<>());
            map.get(start).put(end, values[i]);
            map.get(end).put(start, 1/values[i]);
        }
        //create result array storing the answers
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!map.containsKey(start) || !map.containsKey(end)) {
                result[i] = -1;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            //store the computed value in reference way for later reference
            double[] value = {-1.0};
            dfs(start, end, map, visited, value, 1.0);
            result[i] = value[0];
        }
        return result;
    }

    public void dfs(String start, String end, Map<String, Map<String, Double>> map, HashSet<String> visited, double[] value, double temp) {
        //check if visited
        if (visited.contains(start)) return;
        visited.add(start);
        if (start.equals(end)) {
            value[0] = temp;
            return;
        }
        //enhanced for loop with map.entry class
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            String next = entry.getKey();
            double nextValue = entry.getValue();
            dfs(next, end, map, visited, value, temp * nextValue);
        }
    }
}
