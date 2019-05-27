package top_interview;

import java.util.List;

public class Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    int len = triangle.size();
    int[][] mem = new int[len][len];
    List<Integer> lastRow = triangle.get(len - 1);
    for (int i = 0; i < len; i++) {
      mem[len - 1][i] = lastRow.get(i);
    }
    for (int i = len - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        mem[i][j] = triangle.get(i).get(j) + Math.min(mem[i + 1][j], mem[i + 1][j + 1]);
      }
    }
    return mem[0][0];
  }
}
