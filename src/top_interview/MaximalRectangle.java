package top_interview;

public class MaximalRectangle {

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int h = matrix.length;
    int w = matrix[0].length;
    int[][] histogram = new int[h][w];

    for (int i = 0; i < w; i++) {
      histogram[h - 1][i] = matrix[h - 1][i] - '0';
    }
    for (int i = h - 2; i >= 0; i--) {
      for (int j = 0; j < w; j++) {
        if (matrix[i][j] == '1') {
          histogram[i][j] = histogram[i + 1][j] + 1;
        } else {
          histogram[i][j] = 0;
        }
      }
    }

    int max = 0;
    for (int i = 0; i < h; i++) {
      max = Math.max(max, maxSizeInHistogram(histogram, i));
    }
    return max;
  }

  private int maxSizeInHistogram(int[][] histogram, int index) {
    int max = 0;
    int cur = 0;
    while (cur < histogram[index].length) {
      int next = nextHeightLoc(histogram, index, cur);
      max = Math.max(max, maxSize(histogram, index, cur, next));
      cur = next + 1;
    }
    return max;
  }

  private int nextHeightLoc(int[][] histogram, int index, int start) {
    int next = start;
    while (next + 1 < histogram[index].length && histogram[index][next + 1] >= histogram[index][next]) {
      next++;
    }
    return next;
  }

  private int maxSize(int[][] histogram, int index, int start, int end) {
    int loc = end - 1;
    int max = histogram[index][end];
    int height = histogram[index][end];
    while (loc >= 0) {
      height = Math.min(height, histogram[index][loc]);
      max = Math.max(max, (end - loc + 1) * height);
      loc--;
    }
    return max;
  }
}
