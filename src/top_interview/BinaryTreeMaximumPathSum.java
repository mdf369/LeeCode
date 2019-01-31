package top_interview;

import javafx.util.Pair;

public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = getMax(root);
        if (max <= 0) {
            return max;
        }

        Pair<Integer, Integer> res = maxPathSumOfSubTree(root);
        return Math.max(res.getKey(), res.getValue());
    }

    private Pair<Integer, Integer> maxPathSumOfSubTree(TreeNode node) {
        if (node == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> leftSum = maxPathSumOfSubTree(node.left);
        Pair<Integer, Integer> rightSum = maxPathSumOfSubTree(node.right);
        int rootMax = node.val + Math.max(leftSum.getKey(), rightSum.getKey());
        rootMax = Math.max(rootMax, node.val);
        int max = Math.max(leftSum.getValue(), rightSum.getValue());
        max = Math.max(max, rootMax);
        max = Math.max(max, leftSum.getKey() + rightSum.getKey() + node.val);
        return new Pair<>(rootMax, max);
    }

    private int getMax(TreeNode node) {
        int max = node.val;
        if (node.left != null) {
            max = Math.max(max, getMax(node.left));
        }
        if (node.right != null) {
            max = Math.max(max, getMax(node.right));
        }
        return max;
    }
}
