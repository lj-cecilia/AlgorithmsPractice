//time O(n)
//space O(n)
class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {

        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        return (index == -1) ? word : helper(word, index);
    }

    public String helper(String word, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        for (int i = index + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}