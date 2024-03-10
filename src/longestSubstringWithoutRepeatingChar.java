//time O(n)
//space O(n)

import java.util.HashSet;
import java.util.Set;

class longestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int l = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int end = 0; end < l; end++) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(max, end - start + 1);
            }
            else {
                while (set.contains(s.charAt(end)) && start <= end) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
            }
        }
        return max;
    }
}