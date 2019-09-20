package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {

  public int combinationSum4(int[] nums, int target) {
    return go(nums, target, new HashMap<>());
  }

  private int go(int[] nums, int target, Map<Integer, Integer> mem) {
    if (target < 0) {
      return 0;
    }
    if (target == 0) {
      return 1;
    }

    if (mem.containsKey(target)) {
      return mem.get(target);
    }

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += go(nums, target - nums[i], mem);
    }
    mem.put(target, count);
    return count;
  }
}
