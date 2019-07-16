package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

  private Map<TreeNode, Integer> map = new HashMap<>();

  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int max = root.val;
    if (root.left != null) {
      max += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      max += rob(root.right.left) + rob(root.right.right);
    }

    return Math.max(max, rob(root.left) + rob(root.right));
  }

  private int getMaxVal(TreeNode node) {
    if (node == null) {
      return 0;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }

    int max = node.val;
    if (node.left != null) {
      max += rob(node.left.left) + rob(node.left.right);
    }
    if (node.right != null) {
      max += rob(node.right.left) + rob(node.right.right);
    }

    max = Math.max(max, rob(node.left) + rob(node.right));
    map.put(node, max);
    return max;
  }
}
