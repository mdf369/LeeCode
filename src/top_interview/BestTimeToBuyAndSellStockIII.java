package top_interview;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockIII {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int[][] nextMax = new int[prices.length][2];

    boolean asc = prices[1] > prices[0];
    List<int[]> minList = new ArrayList<>();
    List<int[]> maxList = new ArrayList<>();
    if (asc) {
      minList.add(new int[]{0, prices[0]});
    }
    for (int i = 0; i < prices.length - 1; i++) {
      boolean cur = prices[i + 1] > prices[i];
      if (asc != cur) {
        if (asc) {
          maxList.add(new int[]{i, prices[i]});
        } else {
          minList.add(new int[]{i, prices[i]});
        }
      }
      asc = cur;
    }
    if (asc) {
      maxList.add(new int[]{prices.length - 1, prices[prices.length - 1]});
    }

    if (maxList.size() == 0) {
      return 0;
    } else if (maxList.size() == 1) {
      int[] max = maxList.get(0);
      int minV = Integer.MAX_VALUE;
      for (int i = 0; i < minList.size(); i++) {
        int[] min = minList.get(i);
        if (min[0] >= max[0]) {
          break;
        }
        minV = Math.min(minV, min[1]);
      }
      return Math.max(0, max[1] - minV);
    } else {
      return getMaxProfit(minList, maxList);
    }
  }

  private int getMaxProfit(List<int[]> minList, List<int[]> maxList) {
    int max = 0;
    for (int i = 0; i < maxList.size() - 1; i++) {
      int sum = getMaxProfit(minList, maxList, 0, i + 1) + getMaxProfit(minList, maxList, i + 1, maxList.size());
      max = Math.max(max, sum);
    }
    return max;
  }

  private int getMaxProfit(List<int[]> minList, List<int[]> maxList, int start, int end) {
    int minV = minList.get(start)[1];
    int maxV = maxList.get(start)[1];
    int profit = maxV - minV;
    for (int i = start + 1; i < end; i++) {
      int[] min = minList.get(i);
      int[] max = maxList.get(i);

      if (min[1] < minV) {
        minV = min[1];
        maxV = max[1];
      } else if (max[1] > maxV) {
        maxV= max[1];
      }
      profit = Math.max(profit, maxV - minV);
    }
    return profit;
  }
}
