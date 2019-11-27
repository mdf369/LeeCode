package leetcode;

public class SplitArrayLargestSum {

  private long getSum(int[] nums) {
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }

  private int getMax(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
    }
    return max;
  }

  private int trySplit(int[] nums, long max) {
    int count = 1;
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum > max) {
        sum = nums[i];
        count++;
      }
    }
    return count;
  }

  public int splitArray(int[] nums, int m) {
    long left = getMax(nums);
    long right = getSum(nums);

    if (m == 1) {
      return (int) right;
    }
    if (m == nums.length) {
      return (int) left;
    }

    while (left < right) {
      long middle = left + (right - left) / 2;
      int count = trySplit(nums, middle);
      if (count <= m) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }
    return (int) right;
  }
}
