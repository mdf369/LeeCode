package leetcode;

public class A132Pattern {

  private int getNextAscIndex(int[] nums, int index) {
    int min = nums[index++];
    while (index < nums.length) {
      if (nums[index] <= min) {
        min = nums[index];
        index++;
      } else {
        break;
      }
    }
    return index;
  }

  private int getNextDescIndex(int[] nums, int index) {
    int max = nums[index++];
    while (index < nums.length) {
      if (nums[index] >= max) {
        max = nums[index];
        index++;
      } else {
        break;
      }
    }
    return index;
  }

  public boolean find132pattern(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    int index = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    while (index < nums.length) {
      index = getNextAscIndex(nums, index);
      if (index == nums.length) {
        return false;
      }
      min = nums[index - 1];

      index = getNextDescIndex(nums, index);
      if (index == nums.length) {
        return false;
      }
      max = nums[index - 1];

      for (int i = index; i < nums.length; i++) {
        if (min < nums[i] && nums[i] < max) {
          return true;
        }
      }
    }
    return false;
  }
}
