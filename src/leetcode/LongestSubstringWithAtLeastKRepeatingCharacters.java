package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

  public int longestSubstring(String s, int k) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] counts = new int[26];
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      counts[chars[i] - 'a']++;
    }

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] < k && counts[i] > 0) {
        set.add((char) ('a' + i));
      }
    }

    if (set.isEmpty()) {
      return chars.length;
    }

    int max = 0;
    String[] ss = s.split(buildSplitter(set));
    for (int i = 0; i < ss.length; i++) {
      max = Math.max(max, longestSubstring(ss[i], k));
    }
    return max;
  }

  private String buildSplitter(Set<Character> set) {
    StringBuilder builder = new StringBuilder();
    set.forEach(c -> builder.append(c).append('|'));
    builder.deleteCharAt(builder.length() - 1);
    return builder.toString();
  }
}
