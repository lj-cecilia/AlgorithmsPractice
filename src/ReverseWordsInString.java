//time O(n) iterate the entire string
//space O(n) stack store all words

import java.util.Stack;

class ReverseWordsInString {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (sb.length() != 0) stack.push(sb.toString());
                sb = new StringBuilder();
            }
            else sb.append(ch);
        }
        if (sb.length() != 0) stack.push(sb.toString());

        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
