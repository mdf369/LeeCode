package top_interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<Integer> res = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();
      res.add(node.val);
      if (node.right != null) {
        queue.addFirst(node.right);
      }
      if (node.left != null) {
        queue.addFirst(node.left);
      }
    }
    return res;
  }
}
