package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

  private boolean canWin(int max, int total, int used, Map<Integer, Boolean> mem) {
    if (mem.containsKey(used)) {
      return mem.get(used);
    }

    for (int i = 1; i <= max; i++) {
      int mask = 1 << (i - 1);
      if ((used & mask) == 0) {
        if (total <= i || !canWin(max, total - i, used | mask, mem)) {
          mem.put(used, true);
          return true;
        }
      }
    }
    mem.put(used, false);
    return false;
  }

  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal <= maxChoosableInteger) {
      return true;
    }
    if (desiredTotal > (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
      return false;
    }
    if (desiredTotal == (1 + maxChoosableInteger) * maxChoosableInteger / 2) {
      return (maxChoosableInteger & 1) == 1;
    }

    return canWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
  }
}
