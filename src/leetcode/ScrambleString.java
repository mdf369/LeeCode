package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

  Map<String, Map<String, Boolean>> mem = new HashMap<>();

  public boolean isScramble(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.equals(s2)) {
      return true;
    }
    String reverse = new StringBuilder(s1).reverse().toString();
    if (reverse.equals(s2)) {
      return true;
    }

    int status = getMem(s1, s2);
    if (status == 1) {
      return true;
    } else if (status == 0) {
      boolean flag = false;
      for (int i = 1; i < s1.length(); i++) {
        if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i),
            s2.substring(i))) {
          flag = true;
          break;
        }
      }
      updateMem(s1, s2, flag);
      if (flag) {
        return true;
      }
    }
    status = getMem(reverse, s2);
    if (status == 1) {
      return true;
    } else if (status == 0) {
      boolean flag = false;
      for (int i = 1; i < reverse.length(); i++) {
        if (isScramble(reverse.substring(0, i), s2.substring(0, i)) && isScramble(reverse.substring(i),
            s2.substring(i))) {
          flag = true;
          break;
        }
      }
      updateMem(reverse, s2, flag);
      if (flag) {
        return true;
      }
    }
    return false;
  }

  private void updateMem(String s1, String s2, boolean res) {
    if (mem.containsKey(s1)) {
      mem.get(s1).put(s2, res);
    } else {
      Map<String, Boolean> map = new HashMap<>();
      map.put(s2, res);
      mem.put(s1, map);
    }

    if (mem.containsKey(s2)) {
      mem.get(s2).put(s1, res);
    } else {
      Map<String, Boolean> map = new HashMap<>();
      map.put(s1, res);
      mem.put(s2, map);
    }
  }

  private int getMem(String s1, String s2) {
    if (mem.containsKey(s1)) {
      Map<String, Boolean> map = mem.get(s1);
      if (map.containsKey(s2)) {
        if (map.get(s2)) {
          return 1;
        } else {
          return -1;
        }
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }
}
