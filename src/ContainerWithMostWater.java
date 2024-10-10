//time O(n) one traversal
//space O(1)
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = height.length;

        int result = 0;
        int left = 0, right = l - 1;
        while (left != right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return result;
    }
}