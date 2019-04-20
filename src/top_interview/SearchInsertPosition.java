package top_interview;

public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    if (nums.length == 0 || target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    return findIndex(nums, 0, nums.length, target);
  }

  private int findIndex(int[] nums, int start, int end, int target) {
    if (end - start <= 1) {
      if (target > nums[start]) {
        return start + 1;
      } else {
        return start;
      }
    }

    int middle = (start + end) / 2;
    if (nums[middle] == target) {
      return middle;
    } else if (nums[middle] > target) {
      return findIndex(nums, start, middle, target);
    } else {
      return findIndex(nums, middle + 1, end, target);
    }
  }
}
