package top_interview;

public class SumRootToLeafNumbers {

  private int sum = 0;

  public int sumNumbers(TreeNode root) {
    go(root, 0);
    return sum;
  }

  private void go(TreeNode node, int preSum) {
    if (node == null) {
      return;
    }

    int curSum = preSum * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum += curSum;
    } else {
      go(node.left, curSum);
      go(node.right, curSum);
    }
  }
}
