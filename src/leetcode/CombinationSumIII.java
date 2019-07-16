package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    go(k, n, 1, new int[k], 0, 0, res);
    return res;
  }

  private void go(int k, int n, int start, int[] subres, int index, int subsum, List<List<Integer>> res) {
    if (index == k - 1) {
      int target = n - subsum;
      if (target >= start && target < 10) {
        subres[index] = target;
        List<Integer> subList = new ArrayList<>();
        for (int one : subres) {
          subList.add(one);
        }
        res.add(subList);
      }
      return;
    }
    if (subsum >= n || start > 9) {
      return;
    }

    for (int i = start; i < 10; i++) {
      subres[index] = i;
      go(k, n, i + 1, subres, index + 1, subsum + i, res);
    }
  }
}
