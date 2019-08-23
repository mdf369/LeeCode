package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

  private int maxLen = 0;
  private int maxStartIndex = -1;

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;

    boolean[][] validMap = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j <= i; j++) {
        validMap[i][j] = nums[i] % nums[j] == 0;
      }
    }

    int[] lenMem = new int[len];
    int[] parentMem = new int[len];

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i; j < len; j++) {
        if (validMap[j][i] && lenMem[i] < lenMem[j] + 1) {
          lenMem[i] = lenMem[j] + 1;
          parentMem[i] = j;

          if (maxLen < lenMem[i]) {
            maxLen = lenMem[i];
            maxStartIndex = i;
          }
        }
      }
    }

    List<Integer> res = new ArrayList<>(maxLen);
    for (int i = 0; i < maxLen; i++) {
      res.add(nums[maxStartIndex]);
      maxStartIndex = parentMem[maxStartIndex];
    }
    return res;
  }
}
