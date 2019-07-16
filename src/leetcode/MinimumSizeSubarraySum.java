package leetcode;

public class MinimumSizeSubarraySum {

  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null) {
      return 0;
    }

    int left = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum >= s) {
        while (sum >= s) {
          sum -= nums[left];
          left++;
        }
        left--;
        sum += nums[left];
        min = Math.min(min, i - left + 1);
      }
    }
    if (sum < s) {
      return 0;
    }
    return min;
  }
}
