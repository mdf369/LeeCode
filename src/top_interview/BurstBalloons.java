package top_interview;

public class BurstBalloons {

  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int len = nums.length;
    int[] values = new int[len + 2];
    for (int i = 0; i < len; i++) {
      values[i + 1] = nums[i];
    }
    values[0] = values[len + 1] = 1;

    int[][] mem = new int[len + 2][len + 1];
    for (int i = 1; i <= len; i++) {
      mem[i][i] = getVal(values, i);
    }

    for (int sublen = 1; sublen < len; sublen++) {
      for (int i = 1; i <= len; i++) {
        int end = i + sublen;
        if (end > len) {
          break;
        }

        int max = 0;
        for (int j = i; j <= end; j++) {
          max = Math.max(max,
              mem[i][j - 1] + values[i - 1] * values[j] * values[end + 1] + mem[j + 1][end]);
        }
        mem[i][end] = max;
      }
    }

    return mem[1][len];
  }

  private int getVal(int[] values, int index) {
    return values[index - 1] * values[index] * values[index + 1];
  }
}
