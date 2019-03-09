package top_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TargetSum {

  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    return go(nums, 0, map, S);
  }

  private int go(int[] nums, int index, Map<Integer, Integer> map, int target) {
    if (index == nums.length - 1) {
      int res = 0;
      if (map.containsKey(target + nums[index])) {
        res += map.get(target + nums[index]);
      }
      if (map.containsKey(target - nums[index])) {
        res += map.get(target - nums[index]);
      }
      return res;
    }

    map = getNewMap(map, nums[index]);
    return go(nums, index + 1, map, target);
  }

  private Map<Integer, Integer> getNewMap(Map<Integer, Integer> map, int num) {
    Map<Integer, Integer> newMap = new HashMap<>();
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      update(newMap, entry.getKey() + num, entry.getValue());
      update(newMap, entry.getKey() - num, entry.getValue());
    }

    return newMap;
  }

  private void update(Map<Integer, Integer> map, int num, int count) {
    if (map.containsKey(num)) {
      count += map.get(num);
    }
    map.put(num, count);
  }
}
