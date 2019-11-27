package leetcode;

public class CircularArrayLoop {

  private int nextIndex(int index, int move, int size) {
    int next = (index + move) % size;
    if (next < 0) {
      next += size;
    }
    return next;
  }

  private boolean isSameDir(boolean forward, int move) {
    return forward == (move > 0);
  }

  private boolean go(int[] nums, int slowIndex, int fastIndex, boolean forward, boolean first) {
    if (!first && slowIndex == fastIndex) {
      return true;
    }
    if (nums[fastIndex] == 0 || nums[slowIndex] == 0) {
      return false;
    }
    if (!isSameDir(forward, nums[slowIndex]) || !isSameDir(forward, nums[fastIndex])) {
      return false;
    }
    int tempIndex = nextIndex(fastIndex, nums[fastIndex], nums.length);
    if (nums[tempIndex] == 0 || !isSameDir(forward, nums[tempIndex])) {
      return false;
    }

    if (go(nums, nextIndex(slowIndex, nums[slowIndex], nums.length), nextIndex(tempIndex, nums[tempIndex], nums.length), forward, false)) {
      return true;
    } else {
      nums[slowIndex] = nums[fastIndex] = 0;
      return false;
    }
  }

  public boolean circularArrayLoop(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] %= nums.length;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        continue;
      }
      if (go(nums, i, i, nums[i] > 0, true)) {
        return true;
      }
    }
    return false;
  }
}
