//time O(n)
//space O(n)

import java.util.HashSet;
import java.util.List;

class KeysAndRoom {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int room = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == room;
    }

    public void dfs(int current, List<List<Integer>> rooms, HashSet<Integer> visited) {
        //if never visit this room, mark it as visited, and visit rooms with the keys
        if (!visited.contains(current)) {
            visited.add(current);
            for (int integer : rooms.get(current)) {
                dfs(integer, rooms, visited);
            }
        }
        else return;
    }
}