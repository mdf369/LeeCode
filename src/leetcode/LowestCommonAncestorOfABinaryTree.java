package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree {

    private List<TreeNode> list = new ArrayList<>();
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p == null && q == null) {
            return null;
        }

        if (p == null || q == null) {
            return p == null ? q : p;
        }
        if (p == q) {
            return p;
        }

        search(root, p, q);
        return res;
    }

    private boolean search(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        int count = 0;
        if (node == p || node == q) {
            count++;
        }

        if (search(node.left, p, q)) {
            count++;
        }
        if (search(node.right, p, q)) {
            count++;
        }

        if (count >= 1) {
            if (count >= 2 && res == null) {
                res = node;
            }
            return true;
        } else {
            return false;
        }
    }
}
