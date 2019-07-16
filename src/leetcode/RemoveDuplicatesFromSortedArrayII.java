package leetcode;

public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates(int[] nums) {
    int indexToPut = 0;
    int indexToGet = 0;
    int pre = Integer.MAX_VALUE;
    int count = 0;

    while (indexToGet < nums.length) {
      if (nums[indexToGet] == pre) {
        count++;

        if (count == 2) {
          while (indexToGet < nums.length && nums[indexToGet] == pre) {
            indexToGet++;
          }
          count = 0;
        } else {
          nums[indexToPut] = nums[indexToGet];
          indexToGet++;
          indexToPut++;
        }
      } else {
        count = 0;
        pre = nums[indexToGet];
        nums[indexToPut] = nums[indexToGet];
        indexToGet++;
        indexToPut++;
      }
    }
    return indexToPut;
  }
}
