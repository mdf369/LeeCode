package leetcode;

public class DiagonalTraverse {

  private int next(int[] loc, int dir, int h, int w) {
    if (loc[0] == h - 1 && loc[1] == w - 1) {
      return 0;
    }

    if (dir > 0) {
      if (loc[1] == w - 1) {
        loc[0]++;
        dir = -1;
      } else if (loc[0] == 0) {
        loc[1]++;
        dir = -1;
      } else {
        loc[0]--;
        loc[1]++;
      }
    } else {
      if (loc[0] == h - 1) {
        loc[1]++;
        dir = 1;
      } else if (loc[1] == 0) {
        loc[0]++;
        dir = 1;
      } else {
        loc[0]++;
        loc[1]--;
      }
    }
    return dir;
  }

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }

    int h = matrix.length;
    int w = matrix[0].length;
    int size = h * w;
    int[] res = new int[size];
    int dir = 1;
    int[] loc = new int[2];
    res[0] = matrix[0][0];
    for (int i = 1; i < size; i++) {
      dir = next(loc, dir, h, w);
      if (dir == 0) {
        break;
      }

      res[i] = matrix[loc[0]][loc[1]];
    }
    return res;
  }
}
