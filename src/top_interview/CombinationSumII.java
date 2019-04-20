package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    go(candidates, 0, target, res, new ArrayList<>(), new HashSet<>());
    return res;
  }

  private void go(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> subres, Set<List<Integer>> set) {
    for (int i = start; i < candidates.length; i++) {
      if (target == candidates[i]) {
        List<Integer> list = new ArrayList<>(subres);
        list.add(candidates[i]);
        if (!set.contains(list)) {
          res.add(list);
          set.add(list);
        }
        break;
      } else if (target > candidates[i]) {
        List<Integer> list = new ArrayList<>(subres);
        list.add(candidates[i]);
        go(candidates, i + 1, target - candidates[i], res, list, set);
      } else {
        break;
      }
    }
  }
}
