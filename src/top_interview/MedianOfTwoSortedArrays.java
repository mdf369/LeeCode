package top_interview;

import java.util.Random;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int before = (m + n - 1) / 2;
        Random random = new Random(System.currentTimeMillis());

        int sm = 0, sn = 0;
        int em = m, en = n;
        int target;

        if (m == 0 || n == 0){
            int[] nums = m == 0 ? nums2 : nums1;
            int middle = (nums.length - 1) / 2;
            if (nums.length % 2 == 0){
                return (nums[middle] + nums[middle+1]) / 2.0;
            } else {
                return nums[middle];
            }
        }

        while (true){
            int id = random.nextInt(2);
//            if(em - sm >= en - sn){
            if (id == 0){
                target = getMiddleValue(nums1, sm, em);
                int cBefore = getIndex(nums1, target) + getIndex(nums2, target);

                if(before == cBefore) {
                    break;
                } else if (before < cBefore){
                    em = (sm + em) / 2;
                } else {
                    sm = (sm + em) / 2;
                }
            } else {
                target = getMiddleValue(nums2, sn, en);
                int cBefore = getIndex(nums1, target) + getIndex(nums2, target);

                if(before == cBefore) {
                    break;
                } else if (before < cBefore){
                    en = (sn + en) / 2;
                } else {
                    sn = (sn + en) / 2;
                }
            }
        }

        if ((m + n) % 2 == 0){
            int index1 = getIndex(nums1, target);
            int index2 = getIndex(nums2, target);
            int next;
            if (target == nums1[index1]){
                if (index1 + 1 == nums1.length){
                    next = nums2[index2];
                } else {
                    next = Math.min(nums1[index1+1], nums2[index2]);
                }
            } else {
                if (index2 + 1 == nums2.length){
                    next = nums1[index1];
                } else {
                    next = Math.min(nums1[index1], nums2[index2+1]);
                }
            }

            return (target + next) / 2.0;
        } else {
            return target;
        }
    }

    private int getMiddleValue(int[] nums, int start, int end){
        int index = (start + end) / 2;
        return nums[index];
    }

    private int getIndex(int[] nums, int target){
        if (nums.length == 0){
            return 0;
        }
        if (nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end){
            int middle = (end + start) / 2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }
}
