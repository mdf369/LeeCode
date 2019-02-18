package top_interview;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int index = nums.length - k;
        if (index <= 0 || index == nums.length) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < index; i++) {
            newNums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            newNums[i] = nums[index + i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
