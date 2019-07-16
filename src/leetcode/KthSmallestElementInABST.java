package leetcode;

public class KthSmallestElementInABST {

    private boolean flag = false;
    private int depth = 1;

    public int kthSmallest(TreeNode root, int k) {
        return search(root, k);
    }

    private int search(TreeNode node, int k) {
        if (node == null) {
            return -1;
        }

        if (node.left != null) {
            int val = search(node.left, k);
            if (flag) {
                return val;
            }
        }

        if (k == depth) {
            flag = true;
            return node.val;
        } else {
            depth++;
        }

        return search(node.right, k);
    }
}
