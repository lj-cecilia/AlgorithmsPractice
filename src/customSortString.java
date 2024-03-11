import java.util.HashMap;
import java.util.Map;

//time O(n)
//space O(n)
class customSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : order.toCharArray()) {
            int count = (map.get(ch) == null)? 0 : map.get(ch);
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
            map.remove(ch);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}