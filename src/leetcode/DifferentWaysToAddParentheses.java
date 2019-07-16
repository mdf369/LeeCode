package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

  public List<Integer> diffWaysToCompute(String input) {
    return go(input);
  }

  private List<Integer> go(String s) {
    List<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (isOperator(s.charAt(i))) {
        indexList.add(i);
      }
    }

    List<Integer> res = new ArrayList<>();
    if (indexList.isEmpty()) {
      res.add(Integer.parseInt(s));
      return res;
    }
    for (Integer index : indexList) {
      List<Integer> leftList = go(s.substring(0, index));
      List<Integer> rightList = go(s.substring(index + 1));
      char op = s.charAt(index);

      for (Integer left : leftList) {
        for (Integer right : rightList) {
          res.add(getRes(left, right, op));
        }
      }
    }
    return res;
  }

  private int getRes(int left, int right, char op) {
    if (op == '+') {
      return left + right;
    } else if (op == '-') {
      return left - right;
    } else {
      return left * right;
    }
  }

  private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*';
  }
}
