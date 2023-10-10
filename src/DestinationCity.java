import java.util.HashSet;
import java.util.List;

class DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashSet<String> city = new HashSet<>();
        for (List<String> path : paths) {
            String start = path.get(0);
            city.add(start);
        }
        for (List<String> path : paths) {
            String end = path.get(1);
            if (!city.contains(end)) return end;
        }
        return null;
    }
}
