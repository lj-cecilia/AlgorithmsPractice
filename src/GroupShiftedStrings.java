// Jan 4, 2023
// time O(mn) where m = number of string and n = number of chars in string
// space O(m) where m is the number of strings

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            StringBuilder sb = new StringBuilder();
            char prev = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                sb.append((Math.abs(s.charAt(i) - 'a' - prev))%26);
                prev = s.charAt(i);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}