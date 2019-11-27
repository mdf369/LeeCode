package leetcode;

public class LongestPalindrome {

  private int getIndex(char c) {
    if ('a' <= c && c <= 'z') {
      return c - 'a' + 26;
    } else {
      return c - 'A';
    }
  }

  private int[] countLetters(String s) {
    int[] counts = new int[26 * 2];
    for (int i = 0; i < s.length(); i++) {
      counts[getIndex(s.charAt(i))]++;
    }
    return counts;
  }

  public int longestPalindrome(String s) {
    int[] counts = countLetters(s);

    int res = 0;
    boolean oddExist = false;
    for (int count : counts) {
      if ((count & 1) == 1) {
        oddExist = true;
        res += count - 1;
      } else {
        res += count;
      }
    }
    if (oddExist) {
      res++;
    }
    return res;
  }
}
