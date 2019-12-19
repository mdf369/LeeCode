package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MagicalString {

  public int magicalString(int n) {
    if (n < 1) {
      return 0;
    }

    boolean isOne = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(2);
    n -= 3;
    int res = 1;
    while (n > 0) {
      int cur = queue.poll();
      if (cur >= n) {
        if (isOne) {
          res += n;
          break;
        }
      }

      n -= cur;
      for (int i = 0; i < cur; i++) {
        queue.add(isOne ? 1 : 2);
      }
      if (isOne) {
        res += cur;
      }
      isOne = !isOne;
    }

    return res;
  }
}
