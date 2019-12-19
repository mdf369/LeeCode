package leetcode;

public class MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int res = 0;
    int count = 0;
    for (int num : nums) {
      if (num == 0) {
        res = Math.max(res, count);
        count = 0;
      } else {
        count++;
      }
    }
    res = Math.max(res, count);
    return res;
  }
}
