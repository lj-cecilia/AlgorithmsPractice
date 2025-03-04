//time O(n)
//space O(n)
class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        if (n == 0) return result;
        result[1] = 1;
        if (n == 1) return result;
        for (int i = 2; i <= n; i ++) {
            if (i % 2 == 0) {
                result[i] = result[i/2];
            }
            else {
                result[i] = result[i/2] + 1;
            }
        }
        return result;
    }
}

//genius solution
//public int[] countBits(int num) {
//    int[] f = new int[num + 1];
//    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
//    return f;
//}