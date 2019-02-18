package top_interview;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        List<Integer> zeroList = new ArrayList<>();
        List<List<Integer>> negListList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroList.add(i);
                negListList.add(negList);
                negList = new ArrayList<>();
            } else if (nums[i] < 0) {
                negList.add(i);
            }
        }
        negListList.add(negList);

        int max = zeroList.size() == 0 ? Integer.MIN_VALUE : 0;
        zeroList.add(0,-1);
        zeroList.add(nums.length);
        for (int i = 0; i < zeroList.size() - 1; i++) {
            max = Math.max(max, getMaxOfSub(nums, zeroList.get(i) + 1, zeroList.get(i + 1), negListList.get(i)));
        }
        return max;
    }

    private int getMaxOfSub(int[] nums, int start, int end, List<Integer> negLocList) {
        if (start == end) {
            return Integer.MIN_VALUE;
        }

        int max = 1;
        if (negLocList.size() % 2 == 0) {
            for (int i = start; i < end; i++) {
                max = max * nums[i];
            }
        } else {
            if (negLocList.size() == 1) {
                int index = negLocList.get(0);
                if (start == index && index + 1 == end) {
                    return nums[index];
                } else {
                    int left = 1;
                    if (start == index) {
                        left = Integer.MIN_VALUE;
                    } else {
                        while (start < index) {
                            left = left * nums[start++];
                        }
                    }
                    int right = 1;
                    if (index + 1 == end) {
                        right = Integer.MIN_VALUE;
                    } else {
                        end--;
                        while (index < end) {
                            right = right * nums[end--];
                        }
                    }
                    return Math.max(left, right);
                }
            } else {
                int pro1 = 1;
                for (int i = start; i <= negLocList.get(0); i++) {
                    pro1 = pro1 * nums[i];
                }
                int pro2 = 1;
                for (int i = negLocList.get(negLocList.size() - 1); i < end; i++) {
                    pro2 = pro2 * nums[i];
                }
                int middle = 1;
                for (int i = negLocList.get(0) + 1; i < negLocList.get(negLocList.size() - 1); i++) {
                    middle = middle * nums[i];
                }

                max = middle * Math.min(pro1, pro2);
            }
        }
        return max;
    }
}
