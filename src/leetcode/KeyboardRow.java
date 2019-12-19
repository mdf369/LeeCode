package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow {

  private int getIndex(char c) {
    if ('a' <= c && c <= 'z') {
      return c - 'a';
    } else {
      return c - 'A';
    }
  }

  private boolean oneRow(String s, int[] map) {
    int pre = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int cur = map[getIndex(c)];
      if (pre == -1) {
        pre = cur;
      } else if (pre != cur) {
        return false;
      }
    }
    return true;
  }

  public String[] findWords(String[] words) {
    Set<Character>[] sets = new Set[3];
    sets[0] = new HashSet<>();
    sets[0].addAll(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
    sets[1] = new HashSet<>();
    sets[1].addAll(Arrays.asList('a','s','d','f','g','h','j','k','l'));
    sets[2] = new HashSet<>();
    sets[2].addAll(Arrays.asList('z','x','c','v','b','n','m'));

    int[] map = new int[26];
    for (int i = 0; i < sets.length; i++) {
      for (Character c : sets[i]) {
        map[getIndex(c)] = i;
      }
    }

    List<String> list = new ArrayList<>();
    for (String word : words) {
      if (oneRow(word, map)) {
        list.add(word);
      }
    }
    String[] res = new String[list.size()];
    list.toArray(res);
    return res;
  }
}
