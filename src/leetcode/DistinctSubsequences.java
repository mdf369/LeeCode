package leetcode;

public class DistinctSubsequences {

  public int numDistinct(String s, String t) {
    int[][] mem = new int[s.length()][t.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        mem[i][j] = -1;
      }
    }

    int count = go(s, 0, t, 0, mem);
    return count;
  }

  private int go(String s, int sStart, String t, int tStart, int[][] mem) {
    if (tStart == t.length()) {
      return 1;
    }

    if (sStart >= s.length() || s.length() - sStart < t.length() - tStart) {
      return 0;
    }

    if (mem[sStart][tStart] >= 0) {
      return mem[sStart][tStart];
    }

    int count = 0;
    count += go(s, sStart + 1, t, tStart, mem);
    if (s.charAt(sStart) == t.charAt(tStart)) {
      count += go(s, sStart + 1, t, tStart + 1, mem);
    }
    mem[sStart][tStart] = count;
    return count;
  }
}
