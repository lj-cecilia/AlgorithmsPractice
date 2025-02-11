//time O(n)
//space O(n)
class NthTribonacciNumber {
    public int tribonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        if (n <= 3) {
            switch(n) {
                case 0:
                    return 0;
                case 1:
                case 2:
                    return 1;
                case 3:
                    return 2;
            }
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}