package leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = n - 1;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = Integer.MIN_VALUE;
        }

        for (int i = m - 1; i >= 0; i--) {
            while (index >= 0 && nums1[i] < nums2[index]) {
                index--;
            }
            if (index < 0) {
                break;
            }
            swap(nums1, i, i + index + 1);
        }

        index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == Integer.MIN_VALUE) {
                nums1[i] = nums2[index];
                index++;
            }
            if (index >= n) {
                break;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
