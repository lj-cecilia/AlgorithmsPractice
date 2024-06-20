//time O(nlongn)
//space O(n)
//sort and two pointers


import java.util.Arrays;
class successfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int low = 0;
            int high = potions.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                long product = (long)potions[mid] * spells[i];
                if (product < success) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            result[i] = potions.length - low;
        }
        return result;
    }
}
