package top_interview;

public class KthSmallestElementInASortedMatrix {

  public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0) {
      return -1;
    }

    int h = matrix.length;
    int w = matrix[0].length;
    if (w == 0 || h * w < k) {
      return -1;
    }

    int start = matrix[0][0];
    int end = matrix[h - 1][w - 1];
    while (start < end) {
      int middle = (start + end) / 2;
      int count = getK(matrix, middle);
      if (count < k) {
        start = middle + 1;
      } else {
        end = middle;
      }
    }
    return start;
  }

  private int getK(int[][] matrix, int target) {
    int count = 0;
    int x = matrix.length - 1;
    int y = 0;

    while (x >= 0 && y < matrix.length) {
      if (matrix[x][y] <= target) {
        count += x + 1;
        y++;
      } else {
        x--;
      }
    }
    return count;
  }
}
