package leetcode;

public class DiameterOfBinaryTree {

  private int max;

  public int diameterOfBinaryTree(TreeNode root) {
    max = 1;
    getLongestLen(root);
    return max - 1;
  }

  private int getLongestLen(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = getLongestLen(node.left);
    int right = getLongestLen(node.right);
    max = Math.max(max, left + right + 1);
    return Math.max(left, right) + 1;
  }
}
