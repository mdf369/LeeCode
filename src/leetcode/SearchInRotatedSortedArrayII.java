package leetcode;

public class SearchInRotatedSortedArrayII {

  public boolean search(int[] nums, int target) {
    int pivot = getPivot(nums);
    return search(nums, 0, pivot, target) || search(nums, pivot, nums.length, target);
  }

  private int getPivot(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        return i;
      }
    }
    return nums.length;
  }

  private boolean search(int[] nums, int start, int end, int target) {
    if (start >= end) {
      return false;
    }

    int middle = (start + end) / 2;
    if (nums[middle] == target) {
      return true;
    } else if (nums[middle] > target) {
      return search(nums, start, middle, target);
    } else {
      return search(nums, middle + 1, end, target);
    }
  }
}
