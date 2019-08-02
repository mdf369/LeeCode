package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber {

  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] indexes = new int[primes.length];
    List<Integer> list = new ArrayList<>(n);
    list.add(1);
    while (list.size() < n) {
      int minV = Integer.MAX_VALUE;
      for (int i = 0; i < indexes.length; i++) {
        minV = Math.min(minV, list.get(indexes[i]) * primes[i]);
      }
      for (int i = 0; i < indexes.length; i++) {
        if (minV == list.get(indexes[i]) * primes[i]) {
          indexes[i]++;
        }
      }
      list.add(minV);
    }
    return list.get(n - 1);
  }
}
