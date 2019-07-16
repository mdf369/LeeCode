package leetcode;

public class FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    if (nums[0] < nums[nums.length - 1]) {
      return nums[0];
    }

    int rotateIndex = getRotatePoint(nums, 0, nums.length);
    return nums[rotateIndex + 1];
  }

  private int getRotatePoint(int[] nums, int start, int end) {
    if (end - start == 2) {
      return start;
    }

    int middle = (start + end) / 2;
    if (nums[start] > nums[middle]) {
      return getRotatePoint(nums, start, middle + 1);
    } else {
      return getRotatePoint(nums, middle, end);
    }
  }
}
