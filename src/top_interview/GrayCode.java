package top_interview;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

  public List<Integer> grayCode(int n) {
    int len = (int) Math.pow(2, n);
    int[][] bytes = new int[len][n];
    List<Integer> res = new ArrayList<>();

    if (n == 0) {
      res.add(0);
      return res;
    }

    int chu = 2;
    for (int i = 0; i < n; i++) {
      put(bytes, i, len / chu);
      chu *= 2;
    }

    for (int i = 0; i < len; i++) {
      res.add(getV(bytes[i]));
    }
    return res;
  }

  private int getV(int[] bytes) {
    int factor = 0;
    int res = 0;
    for (int i = bytes.length - 1; i >= 0; i--) {
      res += bytes[i] << factor;
      factor++;
    }
    return res;
  }

  private void put(int[][] bytes, int index, int loop) {
    int i = 0;
    while (i < bytes.length) {
      for (int j = 0; j < loop && i < bytes.length; j++) {
        bytes[i][index] = 0;
        i++;
      }
      for (int j = 0; j < loop && i < bytes.length; j++) {
        bytes[i][index] = 1;
        i++;
      }
      for (int j = 0; j < loop && i < bytes.length; j++) {
        bytes[i][index] = 1;
        i++;
      }
      for (int j = 0; j < loop && i < bytes.length; j++) {
        bytes[i][index] = 0;
        i++;
      }
    }
  }
}
