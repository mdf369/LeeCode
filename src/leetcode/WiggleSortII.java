package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int[] newNums = new int[nums.length];
        int index = getMiddle(nums);
        int small = 0;
        int big = 1;
        if (nums.length % 2 == 1) {
            newNums[nums.length - 1] = nums[index];
        } else {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < nums[index]) {
                    count++;
                }
            }

            boolean flag = count >= nums.length / 2;
            if (flag) {
                newNums[1] = nums[index];
                big += 2;
            } else {
                newNums[nums.length - 2] = nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }

            if (nums[i] < nums[index]) {
                newNums[small] = nums[i];
                small += 2;
            } else if (nums[i] > nums[index]) {
                newNums[big] = nums[i];
                big += 2;
            }
        }

        while (small < nums.length) {
            newNums[small] = nums[index];
            small += 2;
        }
        while (big < nums.length) {
            newNums[big] = nums[index];
            big += 2;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    private int getMiddle(int[] nums) {
        int size = (1 + nums.length) / 2;
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ((Integer) nums[o1]).compareTo(nums[o2]);
            }
        });
        for (int i = 0; i < size; i++) {
            heap.add(i);
        }

        for (int i = size; i < nums.length; i++) {
            if (nums[i] <= nums[heap.peek()]) {
                continue;
            } else {
                heap.poll();
                heap.add(i);
            }
        }

        return heap.peek();
    }
}
