//time O(n)
//space O(n)
class BestTimeToBuyOrSellWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int[] buy = new int[l];
        int[] sell = new int[l];

        buy[0] = -prices[0] - fee;
        sell[0] = 0;
        for (int i = 1; i < l; i++) {
            //record the buy or no buy status
            //either do not buy, which is buy[i - 1]
            //either is to buy more from sell[i - 1]
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);

            //record the sell or no sell status
            //either do not sell, which is sell[i - 1]
            //either is to sell more buy[i - 1]
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[l - 1];
    }
}