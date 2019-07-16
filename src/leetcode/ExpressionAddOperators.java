package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    go(num, 0, 0, "", res, target);
    return res;
  }

  private void go(String s, long subres, long pre, String substr, List<String> res, long target) {
    if (s.length() == 0) {
      if (subres == target) {
        res.add(substr);
      }
      return;
    }

    for (int i = 1; i <= s.length(); i++) {
      if (i > 1 && s.charAt(0) == '0') {
        break;
      }
      String cur = s.substring(0, i);
      long curV = Long.parseLong(cur);
      String rest = s.substring(i);

      if (substr.length() == 0) {
        go(rest, curV, pre, cur, res, target);
      } else {
        go(rest, subres + curV, subres, substr + "+" + cur, res, target);
        go(rest, subres - curV, subres, substr + "-" + cur, res, target);
        go(rest, (subres - pre) * curV + pre, pre, substr + "*" + cur, res, target);
      }
    }
  }
}
