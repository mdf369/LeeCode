package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    int[] temp = new int[nums.length];
    for (int i = 0; i <= nums.length; i++) {
      go(nums, 0, temp, 0, i, res);
    }
    return res;
  }

  private void go(int[] nums, int index, int[] candidates, int curLen, int targetLen, List<List<Integer>> res) {
    if (curLen == targetLen) {
      List<Integer> subRes = new ArrayList<>();
      for (int i = 0; i < targetLen; i++) {
        subRes.add(candidates[i]);
      }
      res.add(subRes);
      return;
    }

    for (int i = index; i < nums.length; i = next(nums, i)) {
      candidates[curLen] = nums[i];
      go(nums, i + 1, candidates, curLen + 1, targetLen, res);
    }
  }

  private int next(int[] nums, int index) {
    int pre = nums[index];
    index++;
    while (index < nums.length && nums[index] == pre) {
      index++;
    }
    return index;
  }
}
