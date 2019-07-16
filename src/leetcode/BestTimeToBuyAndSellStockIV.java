package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockIV {

  private int maxProfit = 0;

  public int maxProfit(int k, int[] prices) {
    if (k < 1 || prices == null || prices.length < 2) {
      return 0;
    }

    boolean asc = prices[1] > prices[0];
    List<Integer> minList = new ArrayList<>();
    List<Integer> maxList = new ArrayList<>();
    if (asc) {
      minList.add(prices[0]);
    }
    for (int i = 0; i < prices.length - 1; i++) {
      boolean cur = prices[i + 1] > prices[i];
      if (asc != cur) {
        if (asc) {
          maxList.add(prices[i]);
        } else {
          minList.add(prices[i]);
        }
      }
      asc = cur;
    }
    if (asc) {
      maxList.add(prices[prices.length - 1]);
    }
    if (maxList.size() == 0) {
      return 0;
    }

    int [][][] mem = new int[minList.size()][maxList.size()][k];
    go(minList, maxList, 0, 0, 0, 0, k, mem);
    return maxProfit;
  }

  private int go(List<Integer> minList, List<Integer> maxList, int minIndex, int maxIndex, int profit, int time, int k, int[][][] mem) {
    if (k <= time || minIndex >= minList.size() || maxIndex >= maxList.size()) {
      updateMaxProfit(profit);
      return 0;
    }

    if (mem[minIndex][maxIndex][time] > 0) {
      updateMaxProfit(profit + mem[minIndex][maxIndex][time]);
      return mem[minIndex][maxIndex][time];
    }

    int minV = minList.get(minIndex);
    int tempMax = 0;
    for (int i = maxIndex; i < maxList.size(); i++) {
      int maxV = maxList.get(i);
      if (minV >= maxV) {
        continue;
      }
      tempMax = Math.max(tempMax, go(minList, maxList, i + 1, i + 1, profit + maxV - minV, time + 1, k, mem));
    }
    tempMax = Math.max(tempMax, go(minList, maxList, minIndex + 1, Math.max(minIndex + 1, maxIndex), profit, time, k, mem));
    mem[minIndex][maxIndex][time] = tempMax;
    return tempMax;
  }

  private void updateMaxProfit(int profit) {
    maxProfit = Math.max(maxProfit, profit);
  }
}
