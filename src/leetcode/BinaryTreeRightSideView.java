package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    rightSideView(root, res, 0);
    return res;
  }

  private int rightSideView(TreeNode node, List<Integer> res, int block) {
    if (node == null) {
      return 0;
    }
    if (block <= 0) {
      res.add(node.val);
    }

    int depth = rightSideView(node.right, res, block - 1);
    depth = Math.max(depth, rightSideView(node.left, res, Math.max(block - 1, depth)));
    return depth + 1;
  }
}
