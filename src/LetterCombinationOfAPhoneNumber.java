//time O(4^n)
//space O(n)
//since the word in reference can be up to length of 4

import java.util.ArrayList;
import java.util.List;

class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        String[] reference = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, result, digits, reference);
        return result;
    }

    public void backtrack(StringBuilder sb, int index, List<String> result, String digits, String[] reference) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String word = reference[digits.charAt(index) - '2'];
        for (char ch : word.toCharArray()) {
            sb.append(ch);
            backtrack(sb, index + 1, result, digits, reference);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}