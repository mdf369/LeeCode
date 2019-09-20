package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {

  private int[] nums;
  private Random random;
  private Map<Integer, List<Integer>> indexMap;

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
    random = new Random(System.currentTimeMillis());

    indexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!indexMap.containsKey(nums[i])) {
        indexMap.put(nums[i], new ArrayList<>());
      }
      indexMap.get(nums[i]).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> list = indexMap.get(target);
    return list.get(random.nextInt(list.size()));
  }
}
