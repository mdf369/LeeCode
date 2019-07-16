package leetcode;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        int start = 0;
        int end = nums.length;
        while (true) {
            int index = partition(nums, start, end);
            if (index == -1) {
                return -1;
            } else if (index == nums.length - k) {
                return nums[index];
            } else if (index < nums.length - k) {
                start = index + 1;
            } else {
                end = index;
            }
        }
    }

    private int partition(int[] nums, int start, int end) {
        if (start >= end) {
            return -1;
        }

        if (start == end - 1) {
            return start;
        }

        int p = start;
        int q = end - 1;

        while (true) {
            while (nums[q] >= nums[start]) {
                q--;

                if (q <= p) {
                    swap(nums, start, p);
                    return p;
                }
            }

            while (nums[p] <= nums[start]) {
                p++;

                if (p >= q) {
                    swap(nums, start, q);
                    return q;
                }
            }

            swap(nums, p, q);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
