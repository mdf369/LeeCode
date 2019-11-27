package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {

  public int numberOfArithmeticSlices(int[] A) {
    if (A == null || A.length < 2) {
      return 0;
    }

    Map<Long, Integer>[] mem = new Map[A.length];
    for (int i = 0; i < A.length; i++) {
      mem[i] = new HashMap<>();
    }

    int res = 0;
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < i; j++) {
        long diff = (long) A[i] - A[j];
        int count = mem[i].getOrDefault(diff, 0) + 1;
        if (mem[j].containsKey(diff)) {
          res += mem[j].get(diff);
          count += mem[j].get(diff);
        }
        mem[i].put(diff, count);
      }
    }
    return res;
  }
}
