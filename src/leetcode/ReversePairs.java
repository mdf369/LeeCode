package leetcode;

public class ReversePairs {

  private int count(int[] nums, int index) {
    long min = nums[index] * 2L;
    int count = 0;
    for (int i = index - 1; i >= 0; i--) {
      if (nums[i] > min) {
        count++;
      }
    }
    return count;
  }

  public int reversePairs(int[] nums) {
    int res = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      res += count(nums, i);
    }
    return res;
  }
}
