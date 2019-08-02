package leetcode;

public class PatchingArray {

  public int minPatches(int[] nums, int n) {
    long limit = 1;
    int count = 0;
    int i = 0;
    while (limit <= n) {
      if (i < nums.length && nums[i] <= limit) {
        limit += nums[i];
        i++;
      } else {
        limit = limit << 1;
        count++;
      }
    }
    return count;
  }
}
