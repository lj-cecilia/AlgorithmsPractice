//Dec 24, 2023
//time O(n) space O(1)
class minChangeBinaryString {
    public int minOperations(String s) {
        int a = 0;  //possibility one: 0101
        int b = 0;  //possibility two: 1010
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (index % 2 == 0) {
                if (ch == '0') a++;
                else b++;
            }
            else {
                if (ch == '1') a++;
                else b++;
            }
            index++;
        }
        return Math.min(a, b);
    }
}