package leetcode;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return findMedian(nums2);
        }
        if (nums2 == null) {
            return findMedian(nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        return (findKth(nums1, nums2, 0, 0, (len + 1) / 2) + findKth(nums1, nums2, 0, 0, (len + 2) / 2)) / 2.0;
    }

    private int findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int middle1, middle2;
        middle1 = middle2 = Integer.MAX_VALUE;
        int next1 = start1 + k / 2 - 1;
        int next2 = start2 + k / 2 - 1;
        if (next1 < nums1.length) {
            middle1 = nums1[next1];
        }
        if (next2 < nums2.length) {
            middle2 = nums2[next2];
        }
        if (middle1 < middle2) {
            return findKth(nums1, nums2, next1 + 1, start2, k - k / 2);
        } else {
            return findKth(nums1, nums2, start1, next2 + 1, k - k / 2);
        }
    }

    private double findMedian(int[] nums) {
        int len = nums.length;
        return (nums[len / 2] + nums[(len - 1) / 2]) / 2.0;
    }
}
