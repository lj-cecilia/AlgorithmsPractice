//time O(n)
//space O(1)
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        int i = 0, j = 0;
        while (j < t.length()) {
            if (i <= s.length() - 1 && t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}