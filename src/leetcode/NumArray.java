package leetcode;

public class NumArray {

  private int[] sums;
  private int[] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
    sums = new int[nums.length];

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      sums[i] = sum;
    }
  }

  public void update(int i, int val) {
    int shift = val - nums[i];
    nums[i] = val;
    for (int j = i; j < nums.length; j++) {
      sums[j] += shift;
    }
  }

  public int sumRange(int i, int j) {
    if (i == 0) {
      return sums[j];
    } else {
      return sums[j] - sums[i - 1];
    }
  }
}
