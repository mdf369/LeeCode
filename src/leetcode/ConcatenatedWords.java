package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

  private boolean isConcatenated(String word, Set<String> subWordSet) {
    subWordSet.remove(word);
    int len = word.length();
    boolean[] mem = new boolean[len + 1];
    mem[0] = true;
    for (int i = 0; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        if (mem[j] && subWordSet.contains(word.substring(j, i))) {
          mem[i] = true;
          break;
        }
      }
    }
    subWordSet.add(word);
    return mem[len];
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));

    Set<String> mem = new HashSet<>(Arrays.asList(words));
    List<String> res = new ArrayList<>();
    for (String word : words) {
      if (word.length() == 0) {
        continue;
      }

      if (isConcatenated(word, mem)) {
        res.add(word);
      }
    }
    return res;
  }
}
