//time O(n)
//space O(n)
class tribonacci {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        int[] fb = new int[n + 1];
        fb[0] = 0;
        fb[1] = 1;
        fb[2] = 1;
        for (int i = 3; i <= n; i++) {
            fb[i] = fb[i - 1] + fb[i - 2] + fb[i - 3];
        }
        return fb[n];
    }
}

//time O(n)
//space O(1)
//class tribonacci {
//    public int tribonacci(int n) {
//        if (n < 3) {
//            if (n == 0) return 0;
//            return 1;
//        }
//
//        int result = 0;
//        int first = 0, second = 1, third = 1;
//
//        for (int i = 3; i <= n; i++) {
//            result = first + second + third;
//            first = second;
//            second = third;
//            third = result;
//        }
//
//        return result;
//    }
//}