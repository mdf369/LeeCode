package top_interview;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int rootIndexInPre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildSubTree(int[] preorder, int[] inorder, int start, int end) {
        if (start >= end || rootIndexInPre >= preorder.length) {
            return null;
        }

        int index = search(inorder, preorder[rootIndexInPre], start, end);
        TreeNode root = new TreeNode(preorder[rootIndexInPre]);
        rootIndexInPre++;
        root.left = buildSubTree(preorder, inorder, start, index);
        root.right = buildSubTree(preorder, inorder, index + 1, end);
        return root;
    }

    private int search(int[] nums, int target, int start, int end){
        while (start < end && nums[start] != target){
            start++;
        }
        return start == end ? -1 : start;
    }
}
