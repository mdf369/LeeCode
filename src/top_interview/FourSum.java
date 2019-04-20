package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    Set<List<Integer>> cache = new HashSet<>();

    for (int i = 0; i < nums.length - 3; i++) {
      for (int j = i + 1; j < nums.length - 2; j++) {
        int rest = target - nums[i] - nums[j];
        if (nums[j + 1] + nums[j + 2] > rest) {
          break;
        }
        if (nums[nums.length - 2] + nums[nums.length - 1] < rest) {
          continue;
        }

        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          int subsum = nums[left] + nums[right];
          if (subsum == rest) {
            List<Integer> subRes = new ArrayList<>();
            subRes.add(nums[i]);
            subRes.add(nums[j]);
            subRes.add(nums[left]);
            subRes.add(nums[right]);
            if (!cache.contains(subRes)) {
              cache.add(subRes);
              res.add(subRes);
            }
            left++;
            right--;
          } else if (subsum < rest) {
            left++;
          } else {
            right--;
          }
        }
      }
    }

    return res;
  }
}
