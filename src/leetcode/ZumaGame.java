package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ZumaGame {

  private int minCount = -1;

  private String update(String s, int index) {
    if (index >= s.length() || index - 1 < 0) {
      return s;
    }

    int left = index - 1;
    int right = index;
    if (s.charAt(left) != s.charAt(right)) {
      return s;
    }

    char c = s.charAt(index);
    while (left >= 0 && s.charAt(left) == c) {
      left--;
    }
    while (right < s.length() && s.charAt(right) == c) {
      right++;
    }
    if (right - left - 1 >= 3) {
      s = update(s.substring(0, left + 1) + s.substring(right), left + 1);
    }
    return s;
  }

  private void go(String board, int curCount, Map<Character, Integer> map) {
    if (minCount >= 0 && curCount >= minCount) {
      return;
    }
    if (board.length() == 0) {
      minCount = minCount == -1 ? curCount : Math.min(minCount, curCount);
    }

    int index = 0;
    while (index < board.length()) {
      char c = board.charAt(index);
      int next = index;
      while (next < board.length() && c == board.charAt(next)) {
        next++;
      }

      int handCount = map.getOrDefault(c, 0);
      int needCount = 3 - (next - index);
      if (handCount >= needCount) {
        map.put(c, handCount - needCount);
        go(update(board.substring(0, index) + board.substring(next), index), curCount + needCount, map);
        map.put(c, handCount);
      }
      index = next;
    }
  }

  public int findMinStep(String board, String hand) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < hand.length(); i++) {
      map.put(hand.charAt(i), map.getOrDefault(hand.charAt(i), 0) + 1);
    }

    go(board, 0, map);
    return minCount;
  }
}
