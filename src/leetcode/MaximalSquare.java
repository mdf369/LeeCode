package leetcode;

public class MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int h = matrix.length;
    int w = matrix[0].length;
    int[][] mem = new int[h][w];
    int max = 0;
    for (int i = 0; i < h; i++) {
      mem[i][0] = matrix[i][0] - '0';
      max = Math.max(max, mem[i][0]);
    }
    for (int i = 0; i < w; i++) {
      mem[0][i] = matrix[0][i] - '0';
      max = Math.max(max, mem[0][i]);
    }

    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        if (matrix[i][j] == '1') {
          mem[i][j] = Math.min(mem[i - 1][j - 1], Math.min(mem[i][j - 1], mem[i - 1][j])) + 1;
          max = Math.max(max, mem[i][j]);
        } else {
          mem[i][j] = 0;
        }
      }
    }
    return max * max;
  }
}
