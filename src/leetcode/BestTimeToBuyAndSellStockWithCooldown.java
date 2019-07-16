package leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

  public int maxProfit(int[] prices) {
    if (prices == null|| prices.length < 2) {
      return 0;
    }

    int buy = Integer.MIN_VALUE;
    int preBuy = 0;
    int sell = 0;
    int preSell = 0;
    for (int i = 0; i < prices.length; i++) {
      preBuy = buy;
      buy = Math.max(preSell - prices[i], preBuy);
      preSell = sell;
      sell = Math.max(preBuy + prices[i], preSell);
    }
    return sell;
  }
}
