package leetcode;

import java.util.Arrays;

public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int gIndex = 0;
    int sIndex = 0;
    while (gIndex < g.length && sIndex < s.length) {
      while (sIndex < s.length && g[gIndex] > s[sIndex]) {
        sIndex++;
      }
      if (sIndex < s.length) {
        gIndex++;
        sIndex++;
      }
    }
    return gIndex;
  }
}
