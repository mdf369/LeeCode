package leetcode;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }

        int[][] products = new int[nums.length][2];
        int product1 = 1;
        int product2 = 1;
        for (int i = 0; i < nums.length; i++) {
            products[i][0] = product1;
            products[nums.length - 1 - i][1] = product2;
            product1 *= nums[i];
            product2 *= nums[nums.length - 1 - i];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = products[i][0] * products[i][1];
        }
        return output;
    }
}
