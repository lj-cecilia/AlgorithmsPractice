//time O(n)
//space O(1)
class minimumLength {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)) {
            char ch = s.charAt(start);

            while (s.charAt(start) == ch && start < end) {
                start++;
            }
            //let second while loop do the rest of the indexing work,
            //or else index out of bound in second while loop
            while (s.charAt(end) == ch && start <= end) {
                end--;
            }
        }
        return end - start + 1;
    }
}