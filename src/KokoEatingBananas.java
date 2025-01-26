//time O(logn)
//space O(1)

//binary search, search from 1 to the max range, not search in the array
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int m = l + (r - l)/2;
            int time = 0;
            for (int pile : piles) {
                // time += Math.ceil(pile/m);
                time += (pile + m - 1) / m;
            }
            if (time <= h) {
                r = m;
            }
            else l = m + 1;
        }
        return l;
    }
}