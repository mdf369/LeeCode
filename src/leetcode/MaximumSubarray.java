package leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            max = Math.max(max, n);
        }

        if (max <= 0){
            return max;
        }

        int sum = 0;
        int cSum = 0;
        for (int n : nums){
            cSum += n;
            sum = Math.max(sum, cSum);
            if (cSum < 0) {
                cSum = 0;
            }
        }

        return sum;
    }
}
