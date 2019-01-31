package top_interview;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int index = 0;
        int profit = 0;
        while (index + 1 < prices.length && prices[index] >= prices[index + 1]) {
            index++;
        }
        if (index + 1 >= prices.length) {
            return 0;
        }

        int previousV = prices[index];
        while (true) {
            if (index == prices.length - 1) {
                profit += prices[index] - previousV;
                break;
            }

            if (prices[index] > prices[index + 1]) {
                profit += prices[index] - previousV;
                previousV = prices[index + 1];
            }

            index++;
        }

        return profit;
    }
}
