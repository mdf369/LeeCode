package leetcode;

public class DeleteNodeInABST {

  private TreeNode search(TreeNode root, int key, TreeNode parent) {
    if (root == null) {
      return null;
    } else if (root.val == key) {
      return parent;
    } else if (root.val > key) {
      return search(root.left, key, root);
    } else {
      return search(root.right, key, root);
    }
  }

  private TreeNode combineChildren(TreeNode parent) {
    if (parent.left == null) {
      return parent.right;
    }
    if (parent.right == null) {
      return parent.left;
    }

    TreeNode p = parent.right;
    while (p.left != null) {
      p = p.left;
    }
    p.left = parent.left;
    return parent.right;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    if (root.val == key) {
      return combineChildren(root);
    }

    TreeNode parent = search(root, key, null);
    if (parent == null) {
      return root;
    }
    if (parent.left != null && parent.left.val == key) {
      parent.left = combineChildren(parent.left);
    } else {
      parent.right = combineChildren(parent.right);
    }
    return root;
  }
}
