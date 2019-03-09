package top_interview;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int kCount = 0;
    int sum = 0;
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int count = 0;
      if (map.containsKey(sum)) {
        count = map.get(sum);
      }
      if (map.containsKey(sum - k)) {
        kCount += map.get(sum - k);
      }
      map.put(sum, count + 1);
    }

    return kCount;
  }
}
