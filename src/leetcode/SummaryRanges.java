package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

  public List<String> summaryRanges(int[] nums) {
    if (nums == null) {
      return null;
    }

    List<String> res = new ArrayList<>();
    if (nums.length == 0) {
      return res;
    }

    long pre = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if ((long) nums[i] - nums[i - 1] > 1) {
        addSubRes(res, pre, nums[i - 1]);
        pre = nums[i];
      }
    }
    addSubRes(res, pre, nums[nums.length - 1]);

    return res;
  }

  private void addSubRes(List<String> res, long left, long right) {
    if (left == right) {
      res.add("" + left);
    } else {
      res.add(left + "->" + right);
    }
  }
}
