package leetcode;

public class TotalHammingDistance {

  private int count1(int[] nums) {
    int count = 0;
    for (int num : nums) {
      if ((num & 1) == 1) {
        count++;
      }
    }
    return count;
  }

  private boolean allZero(int[] nums) {
    for (int num : nums) {
      if (num > 0) {
        return false;
      }
    }
    return true;
  }

  public int totalHammingDistance(int[] nums) {
    int res = 0;
    while (!allZero(nums)) {
      int count = count1(nums);
      res += count * (nums.length - count);

      for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[i] >> 1;
      }
    }
    return res;
  }
}
