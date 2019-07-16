package leetcode;

import java.util.Arrays;

public class NextPermutation {

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int index = nums.length - 2;
    while (index >= 0 && nums[index] >= nums[index + 1]) {
      index--;
    }

    Arrays.sort(nums, index + 1, nums.length);

    if (index >= 0) {
      int loc = find(nums, index + 1, nums.length, nums[index]);

      int temp = nums[index];
      nums[index] = nums[loc];
      nums[loc] = temp;
    }
    return;
  }

  private int find(int[] nums, int start, int end, int target) {
    if (start == end) {
      if (target < nums[start]) {
        return start;
      } else {
        return start + 1;
      }
    }

    int middle = (start + end) / 2;
    if (nums[middle] > target) {
      return find(nums, start, middle, target);
    } else {
      return find(nums, middle + 1, end, target);
    }
  }
}
