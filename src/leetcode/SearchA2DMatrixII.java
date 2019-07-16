package leetcode;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int h = matrix.length;
        int w = matrix[0].length;
        if (w == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[h - 1][w - 1]) {
            return false;
        }

        int index = getStartRow(matrix, target, 0, h, w);
        for (int i = index; i < h; i++) {
            int[] nums = matrix[i];
            if (nums[w - 1] < target) {
                continue;
            }
            if (nums[0] > target) {
                break;
            }
            if (searchColumn(nums, target, 0, w)) {
                return true;
            }
        }
        return false;
    }

    private int getStartRow(int[][] matrix, int target, int start, int end, int w) {
        if (start == end) {
            if (matrix[start][w - 1] == target) {
                return start;
            } else if (matrix[start][w - 1] < target) {
                return start + 1;
            } else {
                return start;
            }
        }

        int middle = (start + end) / 2;
        if (matrix[middle][w - 1] == target) {
            return middle;
        } else if (matrix[middle][w - 1] > target) {
            return getStartRow(matrix, target, start, middle, w);
        } else {
            return getStartRow(matrix, target, middle + 1, end, w);
        }
    }

    private boolean searchColumn(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return false;
        }

        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return true;
        } else if (nums[middle] > target) {
            return searchColumn(nums, target, start, middle);
        } else {
            return searchColumn(nums, target, middle + 1, end);
        }
    }
}
