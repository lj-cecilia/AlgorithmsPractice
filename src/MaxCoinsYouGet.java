import java.util.Arrays;

class MaxCoinsYouGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int start = piles.length / 3;
        //before start it's all smallest coins for the 3rd person

        for (int i = start; i < piles.length; i += 2) {
            count += piles[i];
        }
        return count;
    }
}