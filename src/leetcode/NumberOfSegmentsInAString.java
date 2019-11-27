package leetcode;

public class NumberOfSegmentsInAString {

  private int getNextStart(String s, int start, boolean space) {
    while (start < s.length() && (s.charAt(start) == ' ') != space) {
      start++;
    }
    return start;
  }

  public int countSegments(String s) {
    int count = 0;
    int index = 0;

    while (true) {
      index = getNextStart(s, index, false);

      if (index == s.length()) {
        break;
      }
      count++;
      index = getNextStart(s, index, true);
    }
    return count;
  }
}
