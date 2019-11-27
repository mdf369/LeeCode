package leetcode;

public class OnesAndZeroes {

  private int[][] count01(String[] strs) {
    int[][] counts = new int[strs.length][2];
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      for (int j = 0; j < s.length(); j++) {
        counts[i][s.charAt(j) - '0']++;
      }
    }
    return counts;
  }

  public int findMaxForm(String[] strs, int m, int n) {
    int[][] mem = new int[m + 1][n + 1];
    int[][] counts = count01(strs);
    for (int[] count : counts) {
      for (int i = m; i >= count[0]; i--) {
        for (int j = n; j >= count[1]; j--) {
          mem[i][j] = Math.max(mem[i][j], 1 + mem[i - count[0]][j - count[1]]);
        }
      }
    }
    return mem[m][n];
  }
}
