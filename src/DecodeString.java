//time O(K^k * n) k is the max count appear in string s
//space O(sum(k^k * n))


import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') st.push(ch);
            else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && Character.isLetter(st.peek())) {
                    sb.insert(0, st.pop());
                }
                String word = sb.toString();

                st.pop();//pop the [
                sb = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb.insert(0, st.pop());
                }
                int count = Integer.valueOf(sb.toString());
                for (int i = 0; i < count; i++) {
                    for (char c : word.toCharArray()) {
                        st.push(c);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}