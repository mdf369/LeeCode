package top_interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }

    Map<Character, Integer> map = new LinkedHashMap<>();
    Set<Character> set = new HashSet<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (!set.contains(chars[i])) {
        map.put(chars[i], i);
        set.add(chars[i]);
      } else {
        map.remove(chars[i]);
      }
    }
    Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
    if (iterator.hasNext()) {
      return iterator.next().getValue();
    } else {
      return -1;
    }
  }
}
