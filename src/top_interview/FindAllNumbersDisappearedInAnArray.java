package top_interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return Collections.emptyList();
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
        swap(nums, i, nums[i] - 1);
        i--;
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        res.add(i + 1);
      }
    }
    return res;
  }

  private void swap(int[] nums, int p, int q) {
    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }
}
