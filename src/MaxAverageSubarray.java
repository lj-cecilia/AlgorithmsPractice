class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double total = 0;
        double result = 0;
        for (int i = 0; i < k; i++) {
            total += nums[i];
        }
        result = total;

        for (int i = k; i < nums.length; i++) {
            total -= nums[i - k];
            total += nums[i];
            result = Math.max(result, total);
        }
        return result/k;
    }
}