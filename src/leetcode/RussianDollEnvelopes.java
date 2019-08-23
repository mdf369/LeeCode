package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0) {
      return 0;
    }

    Arrays.sort(envelopes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        } else {
          return o1[0] - o2[0];
        }
      }
    });
    int[] mem = new int[envelopes.length];
    for (int i = 0; i < mem.length; i++) {
      mem[i] = 1;
    }

    for (int i = 0; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (canFit(envelopes[i], envelopes[j])) {
          mem[i] = Math.max(mem[i], mem[j] + 1);
        }
      }
    }

    int max = 0;
    for (int i = 0; i < mem.length; i++) {
      max = Math.max(max, mem[i]);
    }
    return max;
  }

  private boolean canFit(int[] parent, int[] child) {
    return parent[0] > child[0] && parent[1] > child[1];
  }
}
