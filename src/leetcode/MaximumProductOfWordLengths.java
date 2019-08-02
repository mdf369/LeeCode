package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductOfWordLengths {

  public int maxProduct(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o2.length() - o1.length();
      }
    });

    int[][] masks = new int[words.length][26];
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        masks[i][words[i].charAt(j) - 'a'] = 1;
      }
    }

    int max = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        int len = words[i].length() * words[j].length();
        if (len <= max) {
          break;
        }

        if (isValid(i, j, masks)) {
          max = len;
        }
      }
    }
    return max;
  }

  private boolean isValid(int x, int y, int[][] masks) {
    for (int i = 0; i < 26; i++) {
      if (masks[x][i] == 1 && masks[y][i] == 1) {
        return false;
      }
    }
    return true;
  }
}
