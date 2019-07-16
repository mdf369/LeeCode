package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    List<LinkedList<String>> subresList = new ArrayList<>();
    LinkedList<String> subres = new LinkedList<>();
    subres.addLast(beginWord);
    subresList.add(subres);
    go(endWord, wordList, subresList, new HashSet<>(), res);
    return res;
  }

  private boolean go(String target, List<String> wordList, List<LinkedList<String>> subresList, Set<String> usedSet, List<List<String>> res) {
    if (subresList.size() == 0) {
      return false;
    }

    boolean flag = false;
    List<LinkedList<String>> newSubresList = new ArrayList<>();
    Set<String> newUsedSet = new HashSet<>(usedSet);
    for (int i = 0; i < subresList.size(); i++) {
      LinkedList<String> subres = subresList.get(i);
      String word = subres.peekLast();
      if (word.equals(target)) {
        flag = true;
        res.add(subres);
        continue;
      }

      if (!flag) {
        for (int j = 0; j < wordList.size(); j++) {
          String candidate = wordList.get(j);
          if (!usedSet.contains(candidate) && isValid(word, candidate)) {
            LinkedList<String> newSubres = new LinkedList<>(subres);
            newSubres.addLast(candidate);
            newUsedSet.add(candidate);
            newSubresList.add(newSubres);
          }
        }
      }
    }

    if (flag) {
      return true;
    } else {
      return go(target, wordList, newSubresList, newUsedSet, res);
    }
  }

  private boolean isValid(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    boolean flag = false;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (flag) {
          return false;
        } else {
          flag = true;
        }
      }
    }

    return flag;
  }
}
