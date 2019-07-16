package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

  private final int SUB_LEN = 10;

  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> appeared = new HashSet<>();
    Set<String> res = new HashSet<>();

    for (int i = 0; i < s.length() - SUB_LEN + 1; i++) {
      String subString = s.substring(i, i + SUB_LEN);
      if (appeared.contains(subString)) {
        res.add(subString);
      }
      appeared.add(subString);
    }

    return new ArrayList<>(res);
  }
}
