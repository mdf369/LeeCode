package leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<>();
    Set<Integer> setRes = new HashSet<Integer>();

    for (int num : nums1) {
      set1.add(num);
    }
    for (int num : nums2) {
      if (set1.contains(num)) {
        setRes.add(num);
      }
    }

    int[] res = new int[setRes.size()];
    int index = 0;
    for (Integer num : setRes) {
      res[index++] = num;
    }
    return res;
  }
}
