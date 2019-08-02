package leetcode;

public class CountOfRangeSum {

  public int countRangeSum(int[] nums, int lower, int upper) {
    long[] sums = new long[nums.length];
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      sums[i] = sum;
    }

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        long rangeSum = getRangeSum(sums, i, j);
        if (rangeSum >= lower && rangeSum <= upper) {
          count++;
        }
      }
    }
    return count;
  }

  private long getRangeSum(long[] sums, int i, int j) {
    if (i == 0) {
      return sums[j];
    } else {
      return sums[j] - sums[i - 1];
    }
  }
}
