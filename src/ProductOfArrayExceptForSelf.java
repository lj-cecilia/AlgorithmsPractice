//time O(n)
//space O(n) with the extra left and right arr
// class ProductOfArrayExceptForSelf {
//     public int[] productExceptSelf(int[] nums) {
//         int l = nums.length;
//         int[] left = new int[l];
//         int[] right = new int[l];
//         int[] result = new int[l];
//         int num = 1;
//         for (int i = 0; i < l; i++) {
//             num = num * nums[i];
//             left[i] = num;
//         }
//         num = 1;
//         for (int i = l - 1; i >= 0; i--) {
//             num = num * nums[i];
//             right[i] = num;
//         }
//         result[0] = right[1];
//         result[l - 1] = left[l - 2];
//         for (int i = 1; i < l - 1; i++) {
//             result[i] = left[i - 1] * right[i + 1];
//         }
//         return result;
//     }
// }

import java.util.Arrays;

//time O(n)
//space O(1) with only result arr
class ProductOfArrayExceptForSelf {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        Arrays.fill(result, 1);
        int left = 1;
        int right = 1;
        for (int i = 0; i < l; i++) {
            left = left * nums[i];
            result[i] = left * 1;
        }

        return result;
    }
}