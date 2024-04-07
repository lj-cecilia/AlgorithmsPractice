//time O(n)
//space O(1)

//greedy approach
class CheckValidString {
    public boolean checkValidString(String s) {
        int open = 0, close = 0;
        int l = s.length() - 1;
        for (int i = 0; i <= l; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            }
            else open--;

            if (s.charAt(l - i) == ')' || s.charAt(l - i) == '*') {
                close++;
            }
            else close--;

            if (open < 0 || close < 0) return false;
        }
        return true;
    }
}
