// time O(2^n)
// space O(2n), the recursion tree


import java.util.LinkedList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    public void dfs(List<String> list, String s, int open, int close, int n) {
        if (open == n && close == n) {
            list.add(s);
            return;
        }
        if (open < n) dfs(list, s + "(", open + 1, close, n);
        //always make sure close < open
        if (close < open) dfs(list, s + ")", open, close + 1, n);
    }
}