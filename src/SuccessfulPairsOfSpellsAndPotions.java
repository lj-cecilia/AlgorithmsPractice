//time O(nlogn)
//space O(n)

import java.util.Arrays;

class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int low = 0;
            int high = potions.length - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                //cast one of the multiplicands to be long for the arithmatic operation to yield valid result
                if ((long)potions[mid] * spell < success) {
                    low = mid + 1;
                }
                else high = mid - 1;
            }
            result[i] = potions.length - low;
        }
        return result;
    }
}