package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    go(new int[n], 0, 0, res, k);
    return res;
  }

  private void go(int[] arr, int start, int depth, List<List<Integer>> res, int k) {
    if (depth == k) {
      res.add(buildList(arr, k));
    }

    for (int i = start; i < arr.length; i++) {
      arr[i] = 1;
      go(arr, i + 1, depth + 1, res, k);
      arr[i] = 0;
    }
  }

  private List<Integer> buildList(int[] arr, int len) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        continue;
      }

      list.add(i + 1);
      if (list.size() >= len) {
        break;
      }
    }
    return list;
  }
}
