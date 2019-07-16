package leetcode;

import javafx.util.Pair;

public class DecodeString {

  public String decodeString(String s) {
    return decodeString(s, 0, s.length());
  }

  private String decodeString(String s, int start, int end) {
    int indexL = getFirstIndex(s, start, end, '[');
    if (indexL >= 0) {
      int indexR = getIndexRight(s, indexL);
      String subS = decodeString(s, indexL + 1, indexR);
      Pair<Integer, Integer> pair = getK(s, indexL, start);
      int count = pair.getKey();

      StringBuilder builder = new StringBuilder();
      if (pair.getValue() > start) {
        builder.append(s.substring(start, pair.getValue()));
      }
      for (int i = 0; i < count; i++) {
        builder.append(subS);
      }
      builder.append(decodeString(s,indexR + 1, end));
      return builder.toString();
    } else {
      return s.substring(start, end);
    }
  }

  private int getFirstIndex(String s, int start, int end, char target) {
    int index = start;
    while (index < end && s.charAt(index) != target) {
      index++;
    }
    if (index == end) {
      return -1;
    } else {
      return index;
    }
  }

  private Pair<Integer, Integer> getK(String s, int end, int limit) {
    int start = end - 1;
    while (start >= limit && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
      start--;
    }
    return new Pair<>(Integer.parseInt(s.substring(start + 1, end)), start + 1);
  }

  private int getIndexRight(String s, int start) {
    int count = 0;
    for (int i = start; i < s.length(); i++) {
      if (s.charAt(i) == '[') {
        count++;
      } else if (s.charAt(i) == ']') {
        count--;
      }

      if (count == 0) {
        return i;
      }
    }
    return -1;
  }
}
