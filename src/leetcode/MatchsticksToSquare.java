package leetcode;

import java.util.Arrays;

public class MatchsticksToSquare {

  private boolean go(int[] nums, int index, int curSum, int targetSum, int fullNum, int fullTarget, boolean[] used) {
    if (curSum > targetSum) {
      return false;
    }
    if (curSum == targetSum) {
      if (fullNum == fullTarget) {
        return true;
      } else {
        return go(nums, 0, 0, targetSum, fullNum + 1, fullTarget, used);
      }
    }

    for (int i = index; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }

      used[i] = true;
      if (go(nums, i + 1, curSum + nums[i], targetSum, fullNum, fullTarget, used)) {
        return true;
      } else {
        used[i] = false;
      }
    }
    return false;
  }

  public boolean makesquare(int[] nums) {
    if (nums == null || nums.length < 4) {
      return false;
    }

    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 4 != 0) {
      return false;
    }

    Arrays.sort(nums);
    int start = 0;
    int end = nums.length - 1;
    while (start < end) {
      int t = nums[start];
      nums[start] = nums[end];
      nums[end] = t;
      start++;
      end--;
    }

    int len = sum / 4;
    return go(nums, 0, 0, len, 0, 3, new boolean[nums.length]);
  }
}
