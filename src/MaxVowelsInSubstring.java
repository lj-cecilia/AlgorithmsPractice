//time O(n)
//space O(1)
class MaxVowelsInSubstring {
    public int maxVowels(String s, int k) {
        String vowel = "aeiou";
        int count = 0;
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (vowel.indexOf(s.charAt(i)) != -1) count++;
        }
        result = count;
        for (int i = k; i < s.length(); i++) {
            if (vowel.indexOf(s.charAt(i)) != -1) count++;
            if (vowel.indexOf(s.charAt(i - k)) != -1) count--;
            result = Math.max(count, result);

        }
        return result;
    }
}