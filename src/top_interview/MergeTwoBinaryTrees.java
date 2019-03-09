package top_interview;

public class MergeTwoBinaryTrees {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }

    merge(t1, t2);
    return t1;
  }

  private void merge(TreeNode node1, TreeNode node2) {
    node1.val += node2.val;

    if (node2.left != null) {
      if (node1.left != null) {
        mergeTrees(node1.left, node2.left);
      } else {
        node1.left = node2.left;
      }
    }

    if (node2.right != null) {
      if (node1.right != null) {
        mergeTrees(node1.right, node2.right);
      } else {
        node1.right = node2.right;
      }
    }
  }
}
