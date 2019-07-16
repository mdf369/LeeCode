package leetcode;

import java.util.LinkedList;

public class BSTIterator {

  private LinkedList<TreeNode> stack = new LinkedList<>();

  public BSTIterator(TreeNode root) {
    addTreeNode(root);
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pollLast();
    addTreeNode(node.right);
    return node.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void addTreeNode(TreeNode node) {
    while (node != null) {
      stack.addLast(node);
      node = node.left;
    }
  }
}
