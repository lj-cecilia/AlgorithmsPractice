import java.util.Stack;

//time O(n) two back to back for loops
//space O(n) stack and stringbuilder
class ReverseVowlsOfStrings {
    public String reverseVowels(String s) {
        String check = "aeiouAEIOU";
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (check.indexOf(ch) != -1) {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (check.indexOf(ch) != -1) {
                result.append(stack.pop());
            }
            else result.append(ch);
        }
        return result.toString();
    }
}
