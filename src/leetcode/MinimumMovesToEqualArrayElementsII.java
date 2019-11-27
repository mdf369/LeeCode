package leetcode;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

  public int minMoves2(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    Arrays.sort(nums);
    int middle = (nums.length - 1) / 2;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res += Math.abs(nums[middle] - nums[i]);
    }
    return res;
  }
}
