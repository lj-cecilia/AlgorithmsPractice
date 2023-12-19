//Dec 19, 2023
//time O(n) space O(1)
class maxProductDifference {
    public int maxProductDifference(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = a;
        int c = Integer.MAX_VALUE;
        int d = c;

        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }

            if (num < c) {
                d = c;
                c = num;
            } else if (num < d) {
                d = num;
            }
        }

        return a * b - c * d;

    }
}