//time O(n)
//space O(n)
class validPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        String S = new StringBuilder(s).reverse().toString();
        return s.equals(S);
    }
}

//class validPalindrome {
//    public boolean isPalindrome(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (char ch : s.toCharArray()) {
//            if (Character.isLetter(ch) || Character.isDigit(ch)) {
//                sb.append(ch);
//            }
//        }
//        String S = sb.toString().toLowerCase();
//        int l = 0;
//        int h = S.length() - 1;
//        while (l < h) {
//            if (S.charAt(l) == S.charAt(h)) {
//                l++;
//                h--;
//            }
//            else return false;
//        }
//        return true;
//    }
//}