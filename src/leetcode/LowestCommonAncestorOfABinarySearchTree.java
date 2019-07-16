package leetcode;

public class LowestCommonAncestorOfABinarySearchTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val == p.val || root.val == q.val) {
      return root;
    }

    boolean flag1 = root.val > p.val;
    boolean flag2 = root.val > q.val;
    if (flag1 != flag2) {
      return root;
    } else if (flag1 == true) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
