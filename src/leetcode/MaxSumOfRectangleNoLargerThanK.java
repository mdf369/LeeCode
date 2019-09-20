package leetcode;

public class MaxSumOfRectangleNoLargerThanK {

  private int getSum(int[][] sums, int x, int y) {
    if (x < 0 || y < 0) {
      return 0;
    }
    return sums[x][y];
  }

  private int getSum(int[][] sums, int x1, int y1, int x2, int y2) {
    return getSum(sums, x2, y2) - getSum(sums, x1 - 1, y2) - getSum(sums, x2, y1 - 1) + getSum(sums, x1 - 1, y1 - 1);
  }

  public int maxSumSubmatrix(int[][] matrix, int k) {
    int h = matrix.length;
    int w = matrix[0].length;

    int[][] sums = new int[h][w];
    for (int i = 0; i < h; i++) {
      sums[i][0] = matrix[i][0];
      for (int j = 1; j < w; j++) {
        sums[i][j] = sums[i][j - 1] + matrix[i][j];
      }
    }
    for (int i = 1; i < h; i++) {
      for (int j = 0; j < w; j++) {
        sums[i][j] += sums[i - 1][j];
      }
    }

    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        for (int l = i; l < h; l++) {
          for (int m = j; m < w; m++) {
            int sum = getSum(sums, i, j, l, m);
            if (sum <= k) {
              maxSum = Math.max(maxSum, sum);
            }
          }
        }
      }
    }
    return maxSum;
  }
}
