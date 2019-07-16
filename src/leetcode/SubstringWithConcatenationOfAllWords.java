package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

  public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || words == null || words.length == 0 || words[0].length() == 0) {
      return Collections.emptyList();
    }

    List<Integer> res = new ArrayList<>();
    int wordLen = words[0].length();
    Map<String, Integer> all = generateMap(words);
    for (int i = 0; i < wordLen; i++) {
      loop(s, i, wordLen, words.length, all, res);
    }
    return res;
  }

  private void loop(String s, int start, int wordLen, int wordNum, Map<String, Integer> map, List<Integer> res) {
    int count = 0;
    int index = start;
    Map<String, Integer> mem = new HashMap<>(map);
    while (index + wordLen <= s.length()) {
      String word = s.substring(index, index + wordLen);
      if (mem.containsKey(word)) {
        count++;
        if (updateKey(mem, word, -1) < 0) {
          while (mem.get(word) < 0) {
            String oldWord = s.substring(start, start + wordLen);
            start += wordLen;
            updateKey(mem, oldWord, 1);
            count--;
          }
        }
        if (count == wordNum) {
          res.add(start);
        }
        index += wordLen;
      } else {
        count = 0;
        start = index = index + wordLen;
        mem.clear();
        mem.putAll(map);
      }
    }
  }

  private Map<String, Integer> generateMap(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      updateKey(map, words[i], 1);
    }
    return map;
  }

  private int updateKey(Map<String, Integer> map, String key, int shift) {
    int count = 0;
    if (map.containsKey(key)) {
      count = map.get(key);
    }
    map.put(key, count + shift);
    return count + shift;
  }
}
