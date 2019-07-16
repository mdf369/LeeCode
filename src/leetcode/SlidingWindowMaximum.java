package leetcode;

import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            update(nums, list, i, k);
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            update(nums, list, i, k);

            res[i - k + 1] = nums[list.peekFirst()];
        }
        return res;
    }

    private void update(int[] nums, LinkedList<Integer> list, int index, int k) {
        if (!list.isEmpty() && list.peekFirst() < index - k + 1) {
            list.removeFirst();
        }
        while (!list.isEmpty() && nums[list.peekLast()] < nums[index]) {
            list.removeLast();
        }
        list.offerLast(index);
    }
}
