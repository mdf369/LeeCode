package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {

  public List<Integer> majorityElement(int[] nums) {
    int a, b;
    a = b = 0;
    if (nums == null) {
      return null;
    }
    if (nums.length == 0) {
      return Collections.emptyList();
    }

    int aCount = 0;
    int bCount = 0;
    for (int num : nums) {
      if (num == a) {
        aCount++;
      } else if (num == b) {
        bCount++;
      } else if (aCount == 0) {
        a = num;
        aCount = 1;
      } else if (bCount == 0) {
        b = num;
        bCount = 1;
      } else {
        aCount--;
        bCount--;
      }
    }
    aCount = bCount = 0;
    for (int num : nums) {
      if (num == a) {
        aCount++;
      } else if (num == b) {
        bCount++;
      }
    }

    List<Integer> res = new ArrayList<>();
    int limit = Math.floorDiv(nums.length, 3);
    if (aCount > limit) {
      res.add(a);
    }
    if (bCount > limit) {
      res.add(b);
    }
    return res;
  }
}
