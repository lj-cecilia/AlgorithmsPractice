//time O(n)
//space O(n)
import java.util.HashSet;

class longestPalindrome {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                max += 2;
            }
            else set.add(ch);
        }
        if (set.size() != 0) {
            max += 1;
        }
        return max;
    }
}
