package leetcode;

public class PredictTheWinner {

  public boolean PredictTheWinner(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return false;
    }

    int[][][] mem = new int[len][len][2];
    for (int i = 0; i < len; i++) {
      mem[i][i][0] = nums[i];
    }
    int[] sums = go(nums, 0, len - 1, mem);
    return sums[0] >= sums[1];
  }

  private int[] go(int[] nums, int start, int end, int[][][] mem) {
    if (start == end || mem[start][end][0] > 0) {
      return mem[start][end];
    }

    int[] sums1 = go(nums, start + 1, end, mem);
    int[] sums2 = go(nums, start, end - 1, mem);
    if (nums[start] + sums1[1] >= nums[end] + sums2[1]) {
      mem[start][end][0] = Math.max(mem[start][end][0], nums[start] + sums1[1]);
      mem[start][end][1] = Math.max(mem[start][end][1], sums1[0]);
    } else {
      mem[start][end][0] = Math.max(mem[start][end][0], nums[end] + sums2[1]);
      mem[start][end][1] = Math.max(mem[start][end][1], sums2[0]);
    }

    return mem[start][end];
  }
}
