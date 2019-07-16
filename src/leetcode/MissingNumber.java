package leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        int sumT = 0;
        for (int num : nums) {
            sumT += num;
        }
        return sum - sumT;
    }
}
