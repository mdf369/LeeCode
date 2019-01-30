package top_interview;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertSubTree(nums, 0, nums.length);
    }

    private TreeNode convertSubTree(int[] nums, int start, int end){
        if (start >= end){
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = convertSubTree(nums, start, middle);
        node.right = convertSubTree(nums, middle + 1, end);
        return node;
    }
}
