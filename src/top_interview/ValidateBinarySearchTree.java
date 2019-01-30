package top_interview;

public class ValidateBinarySearchTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        return isValid(root.left, Integer.MIN_VALUE, root.val, -1) && isValid(root.right, root.val, Integer.MAX_VALUE, 1);
    }

    private boolean isValid(TreeNode node, int min, int max, int status){
        if (node == null) {
            return true;
        }

        if (status == 0 && (node.val <= min || node.val >= max)) {
            return false;
        } else if (status == -1 && node.val >= max){
            return false;
        } else if (status == 1 && node.val <= min) {
            return false;
        }

        boolean res;
        if (status == 0){
            res = isValid(node.left, min, node.val, 0) && isValid(node.right, node.val, max, 0);
        } else if (status == -1){
            res = isValid(node.left, min, node.val, -1) && isValid(node.right, node.val, max, 0);
        } else {
            res = isValid(node.left, min, node.val, 0) && isValid(node.right, node.val, max, 1);
        }
        return res;
    }
}
