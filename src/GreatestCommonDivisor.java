//time O(m + n) for comparing the concatenation of str1 and str2, with length m and length n, which takes m + n time
//the time used for calculating the GCD is similar to log2(min(m, n)) since every modulo operation reduces the size of the number by almost half
//it's larger than half but even for the Fibonacci numbers, the worst case scenario for this problem, the size still reduce by a factor
//of 1.618, the golden ratio. thus we can say this algorithm itself takes about log(min m, n) time
//space O(m + n) for creating the new string str1 + str2 and str2 + str1
class GreatestCommonDivisor {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int length = gcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }
}
