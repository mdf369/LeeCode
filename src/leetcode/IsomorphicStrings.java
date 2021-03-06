package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    Map<Character, Character> map = new HashMap<>();
    Set<Character> valueSet = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);

      if (map.containsKey(c1)) {
        if (map.get(c1) == c2) {
          continue;
        } else {
          return false;
        }
      } else if (valueSet.contains(c2)) {
        return false;
      } else {
        map.put(c1, c2);
        valueSet.add(c2);
      }
    }
    return true;
  }
}
