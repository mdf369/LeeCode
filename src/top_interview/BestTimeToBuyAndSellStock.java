package top_interview;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int previousV = Integer.MAX_VALUE;
        int currentMaxV = -1;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (previousV > prices[i]) {
                maxProfit = Math.max(maxProfit, currentMaxV - previousV);
                previousV = prices[i];
                currentMaxV = -1;
            } else {
                currentMaxV = Math.max(currentMaxV, prices[i]);
            }
        }

        maxProfit = Math.max(maxProfit, currentMaxV - previousV);
        return maxProfit;
    }
}
