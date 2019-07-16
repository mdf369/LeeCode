package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    List<TreeNode> res = go(nums, 0, nums.length);
    return res;
  }

  private List<TreeNode> go(int[] nums, int start, int end) {
    if (start >= end) {
      return new ArrayList<>();
    }

    List<TreeNode> res = new ArrayList<>();
    for (int i = start; i < end; i++) {
      int rootV = nums[i];
      List<TreeNode> leftTrees = go(nums, start, i);
      List<TreeNode> rightTrees = go(nums, i + 1, end);

      if (leftTrees.isEmpty() && rightTrees.isEmpty()) {
        res.add(new TreeNode(rootV));
      } else if (leftTrees.isEmpty()) {
        for (int j = 0; j < rightTrees.size(); j++) {
          TreeNode root = new TreeNode(rootV);
          root.right = rightTrees.get(j);
          res.add(root);
        }
      } else if (rightTrees.isEmpty()) {
        for (int j = 0; j < leftTrees.size(); j++) {
          TreeNode root = new TreeNode(rootV);
          root.left = leftTrees.get(j);
          res.add(root);
        }
      } else {
        for (int j = 0; j < leftTrees.size(); j++) {
          for (int k = 0; k < rightTrees.size(); k++) {
            TreeNode root = new TreeNode(rootV);
            root.left = leftTrees.get(j);
            root.right = rightTrees.get(k);
            res.add(root);
          }
        }
      }
    }
    return res;
  }
}
