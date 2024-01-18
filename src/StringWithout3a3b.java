// Jan 17th
// time O(n) space O(1)
class StringWithout3a3b {
    public String strWithout3a3b(int a, int b) {
        int A = 0;
        int B = 0;
        int l = a + b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if ((a >= b && A != 2 )||(B == 2 && a > 0)) {
                sb.append("a");
                B = 0;
                A++;
                a--;
            }
            else if ((b >= a && B != 2)||(A == 2 && b > 0)) {
                sb.append("b");
                B++;
                A = 0;
                b--;
            }
        }
        return sb.toString()
                ;    }
}