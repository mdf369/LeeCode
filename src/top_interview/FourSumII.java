package top_interview;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int v = C[i] + D[j];
        int count = 0;
        if (map.containsKey(v)) {
          count = map.get(v);
        }
        map.put(v, count + 1);
      }
    }

    int res = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int v = A[i] + B[j];
        if (map.containsKey(-v)) {
          res += map.get(-v);
        }
      }
    }
    return res;
  }
}
