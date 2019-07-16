package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberII {

  public int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
      sum += nums[i];
    }

    return (int) ((3 * set.stream().mapToLong(v -> v).sum() - sum) / 2);
  }
}
