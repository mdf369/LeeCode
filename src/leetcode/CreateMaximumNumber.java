package leetcode;

import java.util.LinkedList;

public class CreateMaximumNumber {

  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int limit = Math.min(k, nums1.length);
    int[] res = new int[k];
    for (int i = Math.max(0, k - nums2.length); i <= limit; i++) {
      updateMaxNumber(res, mergeSubNumber(getMaxSubNumber(nums1, i), getMaxSubNumber(nums2, k - i)));
    }
    return res;
  }

  private int[] getMaxSubNumber(int[] nums, int limit) {
    int lost = nums.length - limit;
    LinkedList<Integer> res = new LinkedList<>();
    for (int num : nums) {
      while (lost > 0 &&  !res.isEmpty() && res.peekLast() < num) {
        res.removeLast();
        lost--;
      }
      res.addLast(num);
    }
    int[] ress = new int[limit];
    for (int i = 0; i < limit; i++) {
      ress[i] = res.pollFirst();
    }
    return ress;
  }

  private int[] mergeSubNumber(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];
    int index = 0;
    int index1 = 0;
    int index2 = 0;
    while (index1 < nums1.length || index2 < nums2.length) {
      if (index1 == nums1.length) {
        res[index] = nums2[index2];
        index2++;
      } else if (index2 == nums2.length) {
        res[index] = nums1[index1];
        index1++;
      } else {
        if (compare(nums1, index1, nums2, index2)) {
          res[index] = nums1[index1];
          index1++;
        } else {
          res[index] = nums2[index2];
          index2++;
        }
      }
      index++;
    }

    return res;
  }

  private boolean compare(int[] num1, int index1, int[] num2, int index2) {
    while (index1 < num1.length && index2 < num2.length && num1[index1] == num2[index2]) {
      index1++;
      index2++;
    }

    if (index1 == num1.length) {
      return false;
    } else if (index2 == num2.length) {
      return true;
    } else {
      return num1[index1] > num2[index2];
    }
  }

  private void updateMaxNumber(int[] max, int[] nums) {
    for (int i = 0; i < max.length; i++) {
      if (nums[i] > max[i]) {
        break;
      }
      if (nums[i] < max[i]) {
        return;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      max[i] = nums[i];
    }
  }
}
