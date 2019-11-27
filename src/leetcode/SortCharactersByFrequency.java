package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharactersByFrequency {

  public String frequencySort(String s) {
    if (s == null) {
      return null;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int count = map.getOrDefault(c, 0);
      map.put(c, count + 1);
    }

    List<Entry<Character, Integer>> list = new ArrayList<>(map.size());
    list.addAll(map.entrySet());
    Collections.sort(list, Comparator.comparingInt(entry -> entry.getValue()));

    StringBuilder builder = new StringBuilder();
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).getValue() == 0) {
        break;
      }

      for (int j = 0; j < list.get(i).getValue(); j++) {
        builder.append(list.get(i).getKey());
      }
    }
    return builder.toString();
  }
}
