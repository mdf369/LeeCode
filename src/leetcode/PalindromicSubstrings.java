package leetcode;

public class PalindromicSubstrings {

  public int countSubstrings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count += getNum(s, i, i);
      count += getNum(s, i, i + 1);
    }
    return count;
  }

  private int getNum(String s, int start, int end) {
    int count = 0;
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
      count++;
    }
    return count;
  }
}
