//Dec 27, 2023
//time O(n) space O(1)
// class minTimeMakeRopeColorful {
//     public int minCost(String colors, int[] neededTime) {
//         int total = 0;
//         int left = 0;
//         int right = 0;
//         while (left < colors.length() && right < colors.length()) {
//             int max = 0;
//             int temp = 0;
//             while (right < colors.length() && colors.charAt(left) == colors.charAt(right)) {
//                 max = Math.max(neededTime[right], max);
//                 total += neededTime[right];
//                 right++;
//             }
//             left = right;
//             total += temp - max;
//         }
//         return total;
//     }
// }

class minTimeMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int max = 0;
        int total = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (i != 0 && colors.charAt(i - 1) != colors.charAt(i)) {
                max = 0;
            }
            total += Math.min(max, neededTime[i]);
            max = Math.max(max, neededTime[i]);

        }
        return total;
    }
}