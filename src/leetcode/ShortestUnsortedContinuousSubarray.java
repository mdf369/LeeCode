package leetcode;

public class ShortestUnsortedContinuousSubarray {

  public int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    int left = -1;
    int right = -1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        left = i;
        break;
      }
    }

    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] > nums[i + 1]) {
        right = i;
        break;
      }
    }

    if (left != -1 && right != -1) {
      int min = nums[left];
      for (int i = left + 1; i < nums.length; i++) {
        min = Math.min(min, nums[i]);
      }

      int max = nums[right];
      for (int i = right - 1; i >= 0; i--) {
        max = Math.max(max, nums[i]);
      }

      int index = left - 1;
      while (index >= 0 && nums[index] > min) {
        index--;
      }
      left = index + 1;

      index = right + 1;
      while (index < nums.length && nums[index] < max) {
        index++;
      }
      right = index - 1;

      return right - left + 1;
    } else {
      return 0;
    }
  }
}
