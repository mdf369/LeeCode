package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

  public List<String> removeInvalidParentheses(String s) {
    if (s == null) {
      return Collections.emptyList();
    }

    int index = 0;
    int countLeft, countRight;
    countLeft = countRight = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        countLeft++;
      } else if (c == ')') {
        if (countLeft > 0) {
          countLeft--;
        } else {
          countRight++;
        }
      }
    }

    Set<String> set = new HashSet<>();
    remomeInvalid(s, 0, countLeft, countRight, set);
    List<String> res = new ArrayList<>();
    res.addAll(set);
    return res;
  }

  private void remomeInvalid(String s, int start, int countL, int countR, Set<String> set) {
    if (countL == 0 && countR == 0) {
      if (isValid(s)) {
        set.add(s);
      }
    }

    for (int i = start; i < s.length(); i++) {
      if (i > start && s.charAt(i) == s.charAt(i - 1)) {
        continue;
      }

      char c = s.charAt(i);
      if (c == '(' && countL > 0) {
        remomeInvalid(s.substring(0, i) + s.substring(i + 1), i, countL - 1, countR, set);
      } else if (c == ')' && countR > 0) {
        remomeInvalid(s.substring(0, i) + s.substring(i + 1), i, countL, countR - 1, set);
      }
    }
  }

  private boolean isValid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
      }

      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }
}
