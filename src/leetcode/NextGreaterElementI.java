package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

  private int getNextGreater(int[] nums, int index, int v) {
    while (index < nums.length && nums[index] <= v) {
      index++;
    }
    return index == nums.length ? -1 : nums[index];
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      map.put(nums2[i], i);
    }

    int[] res = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      res[i] = getNextGreater(nums2, map.get(nums1[i]) + 1, nums1[i]);
    }
    return res;
  }
}
