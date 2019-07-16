package leetcode;

public class EditDistance {

  public int minDistance(String word1, String word2) {
    if (word1 == null && word2 == null) {
      return 0;
    } else if (word1 == null) {
      return word2.length();
    } else if (word2 == null) {
      return word1.length();
    }

    int len1 = word1.length();
    int len2 = word2.length();
    int[][] mem = new int[len1 + 1][len2 + 1];
    for (int i = 0; i <= len1; i++) {
      mem[i][0] = i;
    }
    for (int i = 0; i <= len2; i++) {
      mem[0][i] = i;
    }
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          mem[i][j] = mem[i - 1][j - 1];
        } else {
          int min = mem[i - 1][j - 1];
          min = Math.min(min, mem[i - 1][j]);
          min = Math.min(min, mem[i][j - 1]);
          mem[i][j] = min + 1;
        }
      }
    }

    return mem[len1][len2];
  }
}
