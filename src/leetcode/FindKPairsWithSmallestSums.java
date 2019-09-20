package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindKPairsWithSmallestSums {

  private int getMinIndex(int[] nums, int value) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= value) {
        return i;
      }
    }
    return -1;
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if (nums1.length == 0 || nums2.length == 0) {
      return Collections.emptyList();
    }

    List<List<Integer>> res = new ArrayList<>();
    int len = Math.min(k, nums1.length);
    int[] mem = new int[len];
    int left = 0;
    int right = 0;

    while (left < nums1.length && right < nums2.length && res.size() < k) {
      mem[left] = right + 1;
      res.add(Arrays.asList(nums1[left], nums2[right]));

      if (left == nums1.length - 1) {
        left = getMinIndex(mem, right + 1);
        right++;
      } else if (right == nums2.length - 1) {
        left++;
        right = mem[left];
      } else {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
          if (mem[i] >= nums2.length) {
            continue;
          }
          if (min > nums1[i] + nums2[mem[i]]) {
            left = i;
            right = mem[i];
            min = nums1[left] + nums2[right];
          }
        }
      }
    }
    return res;
  }
}
