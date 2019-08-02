package leetcode;

public class NumMatrix {

  private int[][] sums;

  public NumMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    sums = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      int sum = 0;
      for (int j = 0; j < matrix[i].length; j++) {
        sum += matrix[i][j];
        sums[i][j] = sum + getRangeSum(i - 1, j);
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return getRangeSum(row2, col2) - getRangeSum(row1 - 1, col2) - getRangeSum(row2, col1 - 1) + getRangeSum(row1 - 1, col1 - 1);
  }

  private int getRangeSum(int x, int y) {
    if (sums == null || x < 0 || y < 0) {
      return 0;
    }
    return sums[x][y];
  }
}

