package leetcode;

public class HouseRobberII {

  private int max = 0;

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int[] robbed = new int[nums.length];
    int[][][] mem = new int[nums.length][2][2];
    for (int i = 0; i < nums.length; i++) {
      mem[i][0][0] = -1;
      mem[i][0][1] = -1;
      mem[i][1][0] = -1;
      mem[i][1][1] = -1;
    }
    go(nums, 0, robbed, mem);
    return max;
  }

  private int go(int[] nums, int index, int[] robbed, int[][][] mem) {
    if (index >= nums.length) {
      updateMax(nums, index, robbed, 0);
      return 0;
    }

    boolean canRob = canRob(index, robbed);
    int robIndex = canRob ? 1 : 0;
    if (mem[index][robIndex][robbed[0]] != -1) {
      updateMax(nums, index, robbed, mem[index][robIndex][robbed[0]]);
      return mem[index][robIndex][robbed[0]];
    }

    int after = go(nums, index + 1, robbed, mem);
    if (canRob) {
      robbed[index] = 1;
      after = Math.max(after, go(nums, index + 1, robbed, mem) + nums[index]);
      robbed[index] = 0;
    }

    mem[index][robIndex][robbed[0]] = after;
    return after;
  }

  private boolean canRob(int index, int[] robbed) {
    if (index == 0) {
      return true;
    }
    if (index == robbed.length - 1) {
      return robbed[index - 1] == 0 && robbed[0] == 0;
    } else {
      return robbed[index - 1] == 0;
    }
  }

  private void updateMax(int[] nums, int index, int[] robbed, int after) {
    for (int i = 0; i < index; i++) {
      if (robbed[i] == 1) {
        after += nums[i];
      }
    }

    max = Math.max(max, after);
  }
}
