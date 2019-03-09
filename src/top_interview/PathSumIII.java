package top_interview;

public class PathSumIII {
  public int pathSum(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }

    return getCount(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  private int getCount(TreeNode node, int pre, int target) {
    if (node == null) {
      return 0;
    }

    int count = 0;
    int sum = pre + node.val;
    if (sum == target) {
      count++;
    }
    count += getCount(node.left, sum, target);
    count += getCount(node.right, sum, target);
    return count;
  }
}
