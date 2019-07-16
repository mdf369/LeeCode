package leetcode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start, int end){
        if (end <= start) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (nums[middle] == target){
            return middle;
        } else {
            int left = search(nums, target, start, middle);
            if (left != -1) {
                return left;
            }
            int right = search(nums, target, middle + 1, end);
            if (right != -1){
                return right;
            }
            return -1;
        }
    }
}
