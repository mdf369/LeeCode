package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

  private int getLen(int n) {
    int len = 0;
    while (n > 0) {
      n = n / 10;
      len++;
    }
    return len;
  }

  private void addSegment(int base, int cDepth, int maxDepth, List<Integer> res, int max) {
    if (cDepth > maxDepth) {
      return;
    }

    for (int i = 0; i < 10; i++, base++) {
      if (base > max) {
        break;
      }
      if (base == 0) {
        continue;
      }
      res.add(base);
      addSegment(base * 10, cDepth + 1, maxDepth, res, max);
    }
  }

  public List<Integer> lexicalOrder(int n) {
    int len = getLen(n);
    List<Integer> res = new ArrayList<>();

    addSegment(0, 1, len, res, n);
    return res;
  }
}
