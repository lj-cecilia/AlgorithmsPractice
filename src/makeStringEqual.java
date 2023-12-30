//Dec 30, 2023
//time O(n) space O(1)
class makeStringEqual {
    public boolean makeEqual(String[] words) {
        int[] letters = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                letters[ch - 'a']++;
            }
        }

        int l = words.length;
        for (int num : letters) {
            if (num % l != 0) return false;
        }
        return true;
    }
}