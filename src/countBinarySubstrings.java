//everytime shift from one value to the other, count the mininum pairs to be form with this current count of a number and the previous count of the other number
class countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) curr++;
            else {
                count += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
        }
        return count += Math.min(curr, prev);
    }
}

