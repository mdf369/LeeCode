package top_interview;

public class PalindromePartitioningII {

  public int minCut(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }

    int[] mem = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      mem[i] = -1;
    }
    return minCut(s, 0, mem);
  }

  private int minCut(String s, int start, int[] mem) {
    if (start == s.length()) {
      return -1;
    }

    if (mem[start] != -1) {
      return mem[start];
    }

    int min = minCut(s, start + 1, mem);
    for (int i = start + 2; i <= s.length(); i++) {
      if (isPali(s, start, i)) {
        min = Math.min(min, minCut(s, i, mem));
      }
    }
    mem[start] = min + 1;
    return min + 1;
  }

  private boolean isPali(String s, int start, int end) {
    int p = start;
    int q = end - 1;
    while (p < q) {
      if (s.charAt(p) != s.charAt(q)) {
        return false;
      }
      p++;
      q--;
    }
    return true;
  }
}
