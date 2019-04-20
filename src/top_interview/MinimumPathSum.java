package top_interview;

public class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    if (grid == null) {
      return 0;
    }
    int h = grid.length;
    if (h == 0) {
      return 0;
    }
    int w = grid[0].length;
    if (w == 0) {
      return 0;
    }

    int[][] mem = new int[h][w];
    mem[0][0] = grid[0][0];
    for (int i = 1; i < h; i++) {
      mem[i][0] = grid[i][0] + mem[i-1][0];
    }
    for (int i = 1; i < w; i++) {
      mem[0][i] = grid[0][i] + mem[0][i-1];
    }

    for (int i = 1; i < h; i++) {
      for (int j = 1; j < w; j++) {
        mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + grid[i][j];
      }
    }

    return mem[h - 1][w - 1];
  }
}
