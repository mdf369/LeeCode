package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class UglyNumberII {

  public int nthUglyNumber(int n) {
    if (n == 1) {
      return 1;
    }

    TreeSet<Integer> cache = new TreeSet<>();
    List<Integer> chuList = Arrays.asList(2, 3, 5);
    cache.addAll(chuList);
    int index = 1;
    while (index < n - 1) {
      int lostV = cache.pollFirst();
      index++;
      for (Integer chu : chuList) {
        long candidate = (long) lostV * chu;
        if (candidate <= Integer.MAX_VALUE) {
          cache.add((int) candidate);
        }
      }
    }

    return cache.first();
  }
}
