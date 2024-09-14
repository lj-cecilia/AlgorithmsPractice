//time O(1) for loop 32 times
//space O(1) no extra space
class minBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int s = start & 1;
            int g = goal & 1;
            if (s != g) result++;
            start /= 2;
            goal /= 2;
        }
        return result;
    }
}