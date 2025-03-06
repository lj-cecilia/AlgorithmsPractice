//time O(logn)
//space O(1)
// class Solution {
//     public int minFlips(int a, int b, int c) {
//         int count = 0;
//         while (a != 0 || b != 0 || c != 0) {
//             int goal = c & 1;
//             if (goal == 1) {
//                 if ((a & 1) != 1 && (b & 1) != 1) count++;
//             }
//             else if (goal == 0) {
//                 if ((a & 1) != 0) count++;
//                 if ((b & 1) != 0) count++;
//             }
//             int digit = a & b & 1;
//             a /= 2;
//             b /= 2;
//             c /= 2;
//         }
//         return count;
//     }
// }

class MinimumFlipsToMakeAOBEqualToC {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int A = a & 1;
            int B = b & 1;
            int C = c & 1;
            if ((A | B) != C) {
                if ((A & B) == 0) count++;
                if ((A & B) == 1) count+=2;
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}