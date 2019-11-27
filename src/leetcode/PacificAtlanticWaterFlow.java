package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PacificAtlanticWaterFlow {

  private int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

  private boolean canFlow(int[][] matrix, boolean[][] mem, int xS, int yS, int xT, int yT, int h, int w, boolean isPac) {
    if (xT < 0 || yT < 0) {
      return isPac;
    } else if (xT >= h || yT >= w) {
      return !isPac;
    }
    if (isPac && (xT == 0 || yT == 0)) {
      return true;
    }
    if (!isPac && (xT == h - 1 || yT == w - 1)) {
      return true;
    }
    return matrix[xS][yS] <= matrix[xT][yT];
  }

  private void explore(int[][] matrix, boolean[][] mem, boolean[][] visited, int x, int y, int h, int w, boolean isPac) {
    if (x < 0 || x >= h || y < 0 || y >= w || visited[x][y]) {
      return;
    }

    visited[x][y] = true;
    mem[x][y] = true;
    for (int[] direction : directions) {
      if (canFlow(matrix, mem, x, y, x + direction[0], y + direction[1], h, w, isPac)) {
        explore(matrix, mem, visited, x + direction[0], y + direction[1], h, w, isPac);
      }
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    if (matrix == null) {
      return Collections.emptyList();
    }
    int height = matrix.length;
    if (height == 0) {
      return Collections.emptyList();
    }
    int width = matrix[0].length;
    if (width == 0) {
      return Collections.emptyList();
    }

    boolean[][] pacific = new boolean[height][width];
    boolean[][] atlantic = new boolean[height][width];
    explore(matrix, pacific, new boolean[height][width], 0, 0, height, width, true);
    explore(matrix, atlantic, new boolean[height][width], height - 1, width - 1, height, width, false);

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }
    return res;
  }
}
