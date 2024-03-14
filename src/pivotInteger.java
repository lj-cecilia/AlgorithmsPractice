//time O(n)
//space O(1)
class pivotInteger {
    public int pivotInteger(int n) {
        int start = 0;
        int end = n;
        int sum1 = 0;
        int sum2 = 0;
        while (start <= end) {
            if (sum1 > sum2) {
                sum2 += end;
                end--;
            }
            else if (sum1 <= sum2) {
                sum1 += start;
                start++;
            }
            if (sum1 == sum2 && start == end) {
                return start;
            }
        }
        return -1;
    }
}

// //optimized binary search
//time O(logn)
//space O(1)
// public class Solution {
//     public int pivotInteger(int n) {
//         // Initialize left and right pointers for binary search
//         int left = 1, right = n;

//         // Calculate the total sum of the sequence
//         int totalSum = n * (n + 1) / 2;

//         // Binary search for the pivot point
//         while (left < right) {
//             // Calculate the mid-point
//             int mid = (left + right) / 2;

//             // Check if the difference between the square of mid and the total sum is negative
//             if (mid * mid - totalSum < 0) {
//                 left = mid + 1; // Adjust the left bound if the sum is smaller
//             } else {
//                 right = mid; // Adjust the right bound if the sum is equal or greater
//             }
//         }

//         // Check if the square of the left pointer minus the total sum is zero
//         if (left * left - totalSum == 0) {
//             return left;
//         } else {
//             return -1;
//         }
//     }
// }