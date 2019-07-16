package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    go(nums, new int[nums.length], new ArrayList<>(), res, Integer.MAX_VALUE);
    return res;
  }

  private void go(int[] nums, int[] used, List<Integer> subres, List<List<Integer>> res, int last) {
    if (subres.size() == nums.length) {
      res.add(new ArrayList<>(subres));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i] == 1) {
        continue;
      }
      if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
        continue;
      }

      used[i] = 1;
      subres.add(nums[i]);
      go(nums, used, subres, res, nums[i]);
      used[i] = 0;
      subres.remove(subres.size() - 1);
    }
  }
}
