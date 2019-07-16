package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int res = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        int sum = nums[i] + nums[j];
        int index = getIndex(nums, j + 1, nums.length, target - sum);
        sum += nums[index];
        if (Math.abs(target - sum) < Math.abs(target - res)) {
          res = sum;
        }
      }
    }
    return res;
  }

  private int getIndex(int[] nums, int start, int end, int target) {
    if (start >= end) {
      return start;
    }

    int middle = (start + end) / 2;
    if (nums[middle] < target) {
      if (middle + 1 < end) {
        if (nums[middle + 1] < target) {
          return getIndex(nums, middle + 1, end, target);
        } else {
          return Math.abs(target - nums[middle]) < Math.abs(target - nums[middle + 1]) ? middle : middle + 1;
        }
      } else {
        return middle;
      }
    } else if (nums[middle] > target) {
      if (middle > start) {
        if (nums[middle - 1] > target) {
          return getIndex(nums, start, middle, target);
        } else {
          return Math.abs(target - nums[middle]) < Math.abs(target - nums[middle - 1]) ? middle
              : middle - 1;
        }
      } else {
        return middle;
      }
    } else {
      return middle;
    }
  }
}
