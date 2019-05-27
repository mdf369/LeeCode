package top_interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    LinkedList<Integer> res = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      res.addFirst(node.val);
      if (node.left != null) {
        stack.addFirst(node.left);
      }
      if (node.right != null) {
        stack.addFirst(node.right);
      }
    }
    return res;
  }
}
