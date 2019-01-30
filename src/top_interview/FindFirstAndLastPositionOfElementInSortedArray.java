package top_interview;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        return search(nums, target, 0, nums.length, 0);
    }

    private int[] search(int[] nums, int target, int start, int end, int status){
        if (start >= end){
            return new int[]{-1, -1};
        }

        int middle = (start + end) / 2;
        int cv = nums[middle];

        if (status == 0) {
            if (cv == target) {
                int[] left = search(nums, target, 0, middle, -1);
                int[] right = search(nums, target, middle + 1, end, 1);
                int leftv = left[0] == -1 ? middle : left[0];
                int rightv = right[1] == -1 ? middle : right[1];
                return new int[]{leftv, rightv};
            } else if (cv > target) {
                return search(nums, target, 0, middle, status);
            } else {
                return search(nums, target, middle + 1, end, status);
            }
        } else {
            if (cv == target){
                if (status < 0){
                    int[] res = search(nums, target, 0, middle, status);
                    int index = res[0];
                    if (index == -1){
                        index = middle;
                    }
                    return new int[]{index, -1};
                } else {
                    int[] res = search(nums, target, middle + 1, end, status);
                    int index = res[1];
                    if (index == -1){
                        index = middle;
                    }
                    return new int[]{-1, index};
                }
            } else {
                if (cv < target){
                    if (status < 0){
                        return search(nums, target, middle + 1, end, status);
                    } else {
                        return null;
                    }
                } else {
                    if (status < 0){
                        return null;
                    } else {
                        return search(nums, target, start, middle, status);
                    }
                }
            }
        }
    }
}
