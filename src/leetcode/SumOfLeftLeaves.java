package leetcode;

public class SumOfLeftLeaves {

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
    if (node == null) {
      return 0;
    }

    if (isLeaf(node)) {
      return isLeft ? node.val : 0;
    } else {
      return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }
  }

  public int sumOfLeftLeaves(TreeNode root) {
    return sumOfLeftLeaves(root, false);
  }
}
