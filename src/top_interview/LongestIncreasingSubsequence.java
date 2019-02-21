package top_interview;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }

        int[] mem = new int[nums.length];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (mem[j] + 1 > mem[i]) {
                        mem[i] = mem[j] + 1;
                        max = Math.max(max, mem[i]);
                    }
                }
            }
        }
        return max + 1;
    }
}
