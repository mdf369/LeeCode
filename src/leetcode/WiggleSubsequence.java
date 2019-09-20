package leetcode;

public class WiggleSubsequence {

  private int index;

  private int getStatus(int[] nums) {
    int start = index;
    while (index < nums.length && nums[start] == nums[index]) {
      index++;
    }

    if (index == nums.length) {
      return 0;
    }
    return nums[start] < nums[index] ? 1 : -1;
  }

  public int wiggleMaxLength(int[] nums) {
    int len = nums.length;

    if (len == 0) {
      return 0;
    }

    int count = 1;
    int status = 0;
    index = 0;
    while (index < len) {
      int nextStatus = getStatus(nums);
      if (status != 0 && nextStatus != status) {
        count++;
      }

      status = nextStatus;
    }

    return count;
  }
}
