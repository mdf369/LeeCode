package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PalindromePairs {

  public List<List<Integer>> palindromePairs(String[] words) {
    if (words == null) {
      return null;
    }

    List<List<Integer>> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    Set<Integer> lenSet = new TreeSet<>();
    for (int i = 0; i < words.length; i++) {
      if (map.containsKey(words[i])) {
        int j = map.get(words[i]);
        addRes(res, j, i);
        addRes(res, i, j);
      }
      map.put(getReverse(words[i]), i);
      lenSet.add(words[i].length());
    }

    for (int i = 0; i < words.length; i++) {
      for (Integer len : lenSet) {
        if (len >= words[i].length()) {
          break;
        }

        if (isPalindrome(words[i], 0, words[i].length() - len)) {
          String target = words[i].substring(words[i].length() - len);
          if (map.containsKey(target)) {
            addRes(res, map.get(target), i);
          }
        }
        if (isPalindrome(words[i], len, words[i].length())) {
          String target = words[i].substring(0, len);
          if (map.containsKey(target)) {
            addRes(res, i, map.get(target));
          }
        }
      }
    }

    return res;
  }

  private String getReverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  private boolean isPalindrome(String s, int start, int end) {
    int left = start;
    int right = end - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  private void addRes(List<List<Integer>> res, int i, int j) {
    res.add(Arrays.asList(i, j));
  }
}
