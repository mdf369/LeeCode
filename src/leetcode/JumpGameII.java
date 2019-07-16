package leetcode;

public class JumpGameII {

  public int jump(int[] nums) {
    int[] mem = new int[nums.length];

    for (int i = nums.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= nums[i]; j++) {
        if (i + j >= nums.length) {
          break;
        }
        if (mem[i + j] < 0) {
          continue;
        }
        min = Math.min(min, mem[i + j]);
      }
      if (nums[i] <= 0) {
        mem[i] = -1;
      } else {
        mem[i] = min + 1;
      }
    }
    return mem[0];
  }
}
