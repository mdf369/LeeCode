package top_interview;

public class IncreasingTripletSubsequence {

  public boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }

    int[] cache = new int[2];
    cache[0] = cache[1] = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > cache[1]) {
        return true;
      } else if (nums[i] > cache[0] && nums[i] <= cache[1]) {
        cache[1] = nums[i];
      } else {
        cache[0] = nums[i];
      }
    }
    return false;
  }
}
