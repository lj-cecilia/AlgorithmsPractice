class trappingRainWater {
    public int trap(int[] height) {
        int count = 0;
        int l = height.length;
        int[] left = new int[l];
        int[] right = new int[l];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = l - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        for (int i = 0; i < l; i++) {
            count += Math.min(left[i], right[i]) - height[i];
        }
        return count;

    }
}