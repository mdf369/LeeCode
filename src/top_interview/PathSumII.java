package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumII {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    go(root, 0, sum, res, new ArrayList<>());
    return res;
  }

  private void go(TreeNode node, int sum, int target, List<List<Integer>> res, List<Integer> subRes) {
    if (node == null) {
      return;
    }

    sum += node.val;
    subRes.add(node.val);
    if (isLeaf(node)) {
      if (sum == target) {
        res.add(new ArrayList<>(subRes));
      }
      subRes.remove(subRes.size() - 1);
      return;
    }

    go(node.left, sum, target, res, subRes);
    go(node.right, sum, target, res, subRes);
    subRes.remove(subRes.size() - 1);
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }
}
