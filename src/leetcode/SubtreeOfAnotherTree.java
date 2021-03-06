package leetcode;

public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) {
      return true;
    }
    if (s == null) {
      return false;
    }

    if (isSame(s, t)) {
      return true;
    } else {
      return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
  }

  private boolean isSame(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }

    if (node1 == null || node2 == null) {
      return false;
    }

    if (node1.val != node2.val) {
      return false;
    } else {
      return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }
  }
}
