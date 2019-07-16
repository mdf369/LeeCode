package leetcode;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] mem) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (mem[amount - 1] != 0) {
            return mem[amount - 1];
        }

        int minCount = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < coins.length; i++) {
            int count = coinChange(coins, amount - coins[i], mem);
            if (count == -1) {
                continue;
            } else {
                minCount = Math.min(minCount, count);
                flag = true;
            }
        }
        if (flag) {
            mem[amount - 1] = minCount + 1;
            return minCount + 1;
        } else {
            mem[amount - 1] = -1;
            return -1;
        }
    }
}
