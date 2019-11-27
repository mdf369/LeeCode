package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int curIndex = 0;
    while (curIndex < nums.length) {
      int index = nums[curIndex] - 1;

      if (index == curIndex || nums[curIndex] == -1) {
        curIndex++;
      } else if (nums[index] == nums[curIndex]) {
        res.add(nums[curIndex]);
        nums[index] = nums[curIndex] = -1;
        curIndex++;
      } else {
        int t = nums[curIndex];
        nums[curIndex] = nums[index];
        nums[index] = t;
      }
    }
    return res;
  }
}
