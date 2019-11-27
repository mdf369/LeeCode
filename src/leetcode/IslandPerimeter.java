package leetcode;

public class IslandPerimeter {

  int[][][] dirPairs = new int[][][]{{{-1,0},{0,0}},{{0,-1},{0,0}},{{-1,-1},{-1,0}},{{-1,-1},{0,-1}}};
  int[][] shifts = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

  private boolean isValidLoc(int x, int y, int height, int width) {
    return (x >= 0 && x < height) && (y >=0 && y < width);
  }

  private int nextDirIndex(int[][] grid, int x, int y, int height, int width, int preDirIndex) {
    for (int i = 0; i < dirPairs.length; i++) {
      if (i + preDirIndex == 3) {
        continue;
      }

      int x0 = x + dirPairs[i][0][0];
      int y0 = y + dirPairs[i][0][1];
      int x1 = x + dirPairs[i][1][0];
      int y1 = y + dirPairs[i][1][1];

      int v0 = isValidLoc(x0, y0, height, width) ? grid[x0][y0] : 0;
      int v1 = isValidLoc(x1, y1, height, width) ? grid[x1][y1] : 0;
      if (v0 + v1 == 1) {
        return i;
      }
    }
    return -1;
  }

  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int tx, ty;
    tx = ty = -1;
    int height = grid.length;
    int width = grid[0].length;
    boolean flag = false;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (grid[i][j] == 1) {
          tx = i;
          ty = j;
          flag = true;
          break;
        }
      }
      if (flag) {
        break;
      }
    }

    int res = 1;
    int x = tx;
    int y = ty + 1;
    int pre = 0;
    while (x != tx || y != ty) {
      int next = nextDirIndex(grid, x, y, height, width, pre);
      x += shifts[next][0];
      y += shifts[next][1];
      res++;
      pre = next;
    }
    return res;
  }
}
