package leetcode;

public class ShortestPalindrome {

  public String shortestPalindrome(String s) {
    int p = 0;
    for (int q = s.length() - 1; q >= 0; q--) {
      if (s.charAt(p) == s.charAt(q)) {
        p++;
      }
    }
    if (p == s.length()) {
      return s;
    }
    String rest = s.substring(p);
    return new StringBuilder(rest).reverse().toString() + shortestPalindrome(s.substring(0, p)) + rest;
  }
}
