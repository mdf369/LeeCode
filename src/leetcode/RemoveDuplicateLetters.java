package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    return removeDuplicateLetters(s, 0, new HashSet<>(), new StringBuilder());
  }

  private String removeDuplicateLetters(String s, int index, Set<Character> existSet, StringBuilder builder) {
    if (index == s.length()) {
      return builder.toString();
    }

    int[] counts = new int[26];
    for (int i = index; i < s.length(); i++) {
      counts[s.charAt(i) - 'a']++;
    }

    int pos = -1;
    for (int i = index; i < s.length(); i++) {
      char c = s.charAt(i);
      if (existSet.contains(c)) {
        continue;
      }

      if (pos == -1) {
        pos = i;
      } else if (c < s.charAt(pos)) {
        pos = i;
      }

      counts[c - 'a']--;
      if (counts[c - 'a'] == 0) {
        break;
      }
    }

    if (pos != -1) {
      char c = s.charAt(pos);
      builder.append(c);
      existSet.add(c);
      return removeDuplicateLetters(s, pos + 1, existSet, builder);
    } else {
      return builder.toString();
    }
  }
}
