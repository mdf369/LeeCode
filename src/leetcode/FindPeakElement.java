package leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        boolean asc = true;
        for (int i = 1; i < nums.length; i++) {
            boolean next = nums[i-1] < nums[i];
            if (next) {
                asc = true;
            } else {
                if (asc) {
                    return i - 1;
                } else {
                    asc = false;
                }
            }
        }

        if (asc) {
            return nums.length - 1;
        } else {
            return -1;
        }
    }
}
