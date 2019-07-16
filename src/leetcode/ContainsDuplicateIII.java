package leetcode;

import java.util.TreeSet;

public class ContainsDuplicateIII {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> cache = new TreeSet<>();
    int head = 0;
    int tail = 0;
    while (head < nums.length) {
      if (head - tail > k) {
        cache.remove((long) nums[tail]);
        tail++;
      }
      Long left = cache.ceiling((long) nums[head] - t);
      Long right = cache.floor((long) nums[head] + t);
      if (left != null && right != null && left <= right) {
        return true;
      }

      cache.add((long) nums[head]);
      head++;
    }
    return false;
  }
}
