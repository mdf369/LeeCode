package top_interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllAnagramsInAString {

  public List<Integer> findAnagrams(String s, String p) {
    if (s == null || p == null || s.length() < p.length()) {
      return Collections.emptyList();
    }

    Map<Character, Integer> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < p.length(); i++) {
      addC(map, p.charAt(i));
      set.add(p.charAt(i));
    }

    int start = 0;
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        int flag = removeC(map, c);
        if (flag > 0) {
          if (map.isEmpty()) {
            res.add(start);
            addC(map, s.charAt(start));
            start++;
          }
        } else {
          while (start < i && s.charAt(start) != c) {
            addC(map, s.charAt(start));
            start++;
          }
          start++;
        }
      } else {
        for (int j = start; j < i; j++) {
          addC(map, s.charAt(j));
        }
        start = i + 1;
      }
    }
    return res;
  }

  private void addC(Map<Character, Integer> map, char c) {
    int count = 0;
    if (map.containsKey(c)) {
      count = map.get(c);
    }
    map.put(c, count + 1);
  }

  private int removeC(Map<Character, Integer> map, char c) {
    if (map.containsKey(c)) {
      int count = map.get(c);
      if (count > 1) {
        map.put(c, count - 1);
      } else {
        map.remove(c);
      }
      return 1;
    } else {
      return -1;
    }
  }
}
