package leetcode;

public class FlattenBinaryTreeToLinkedList {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    flattenWithValue(root);
  }

  private TreeNode flattenWithValue(TreeNode node) {
    if (node == null) {
      return null;
    }

    if (node.left == null && node.right == null) {
      return node;
    } else if (node.left == null) {
      return flattenWithValue(node.right);
    } else if (node.right == null) {
      node.right = node.left;
      node.left = null;
      return flattenWithValue(node.right);
    } else {
      TreeNode left = flattenWithValue(node.left);
      TreeNode right = flattenWithValue(node.right);
      left.right = node.right;
      node.right = node.left;
      node.left = null;
      return right;
    }
  }
}
