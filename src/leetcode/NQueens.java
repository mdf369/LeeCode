package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    go(n, 0, new ArrayList<>(), res);
    return res;
  }

  private void go(int n, int index, List<Integer> preLocList, List<List<String>> res) {
    if (index == n) {
      List<String> solution = build(preLocList);
      res.add(solution);
    }

    for (int i = 0; i < n; i++) {
      if (isValid(index, i, preLocList)) {
        preLocList.add(i);
        go(n, index + 1, preLocList, res);
        preLocList.remove(preLocList.size() - 1);
      }
    }
  }

  private List<String> build(List<Integer> locList) {
    List<String> graph = new ArrayList<>();
    for (int i = 0; i < locList.size(); i++) {
      graph.add(buildLine(locList.get(i), locList.size()));
    }
    return graph;
  }

  private String buildLine(int index, int n) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i == index) {
        builder.append('Q');
      } else {
        builder.append('.');
      }
    }
    return builder.toString();
  }

  private boolean isValid(int x, int y, List<Integer> preLocList) {
    for (int i = 0; i < preLocList.size(); i++) {
      if (preLocList.get(i) == y) {
        return false;
      }
      if (Math.abs(i - x) == Math.abs(preLocList.get(i) - y)) {
        return false;
      }
    }
    return true;
  }
}
