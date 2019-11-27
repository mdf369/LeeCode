package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {

  private int buildMask(int oneNum) {
    int mask = 0;
    for (int i = 0; i < 32; i++) {
      mask = mask << 1;
      if (i < oneNum) {
        mask++;
      }
    }
    return mask;
  }

  public int findMaximumXOR(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int res = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < 32; i++) {
      int mask = buildMask(i + 1);
      for (int num : nums) {
        set.add(mask & num);
      }

      int t = res | (1 << (31 - i));
      for (Integer num : set) {
        if (set.contains(t ^ num)) {
          res = t;
          break;
        }
      }
      set.clear();
    }
    return res;
  }
}
