package leetcode;

public class IsSubsequence {

  private boolean go(String s, int indexS, String t, int startT) {
    if (indexS >= s.length()) {
      return true;
    }

    while (startT < t.length()) {
      if (s.charAt(indexS) == t.charAt(startT)) {
        if (go(s, indexS + 1, t, startT + 1)) {
          return true;
        }
      }

      startT++;
    }
    return false;
  }

  public boolean isSubsequence(String s, String t) {
    return go(s, 0, t, 0);
  }
}
