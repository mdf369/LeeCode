package top_interview;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

  public boolean canPartition(int[] nums) {
    if (nums == null) {
      return true;
    }

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if ((sum & 1) == 1) {
      return false;
    }

    int target = sum / 2;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (update(set, nums[i], target)) {
        return true;
      }
    }
    return false;
  }

  private boolean update(Set<Integer> set, int num, int target) {
    Set<Integer> newSumSet = new HashSet<>();
    if (num == target) {
      return true;
    }
    for (Integer integer : set) {
      int tempSum = integer + num;
      if (tempSum == target) {
        return true;
      } else if (tempSum < target) {
        newSumSet.add(tempSum);
      }
    }
    set.addAll(newSumSet);
    set.add(num);
    return false;
  }
}
