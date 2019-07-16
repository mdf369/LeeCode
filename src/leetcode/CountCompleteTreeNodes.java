package leetcode;

public class CountCompleteTreeNodes {

  private int count = 0;

  public int countNodes(TreeNode root) {
    getStatusWhileCount(root);
    return count;
  }

  public int getStatusWhileCount(TreeNode node) {
    if (node == null) {
      return 2;
    }

    int left = getStatusWhileCount(node.left);
    int right = getStatusWhileCount(node.right);
    if (right < 2) {
      return 0;
    } else {
      if (left > 0) {
        count++;
      }
      return left;
    }
  }
}
