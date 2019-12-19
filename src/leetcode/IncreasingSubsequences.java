package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

  private boolean isIncreasing(List<Integer> list, int v) {
    return list.isEmpty() || list.get(list.size() - 1) <= v;
  }

  private void go(int[] nums, int index, List<Integer> cur, Set<List<Integer>> res) {
    if (index >= nums.length) {
      return;
    }

    for (int i = index; i < nums.length; i++) {
      if (isIncreasing(cur, nums[i])) {
        List<Integer> newCur = new ArrayList<>(cur);
        newCur.add(nums[i]);
        if (newCur.size() >= 2) {
          res.add(newCur);
        }
        go(nums, i + 1, newCur, res);
      }
    }
  }

  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    go(nums, 0, new ArrayList<>(), res);
    return new ArrayList<>(res);
  }
}
