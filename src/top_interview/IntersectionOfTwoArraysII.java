package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null || nums2 == null) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      Integer count = map.get(nums1[i]);
      if (count == null) {
        map.put(nums1[i], 1);
      } else {
        map.put(nums1[i], count + 1);
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums2.length; i++) {
      Integer count = map.get(nums2[i]);
      if (count == null) {
        continue;
      } else {
        count--;
        if (count == 0) {
          map.remove(nums2[i]);
        } else {
          map.put(nums2[i], count);
        }
        list.add(nums2[i]);
      }
    }

    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
