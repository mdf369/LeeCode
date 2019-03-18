package top_interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

  public int numJewelsInStones(String J, String S) {
    if (J == null || J.length() == 0 || S == null || S.length() == 0) {
      return 0;
    }

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < J.length(); i++) {
      set.add(J.charAt(i));
    }

    int count = 0;
    for (int i = 0; i < S.length(); i++) {
      if (set.contains(S.charAt(i))) {
        count++;
      }
    }
    return count;
  }
}
