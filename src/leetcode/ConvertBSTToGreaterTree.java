package leetcode;

public class ConvertBSTToGreaterTree {

  private int sum;

  public TreeNode convertBST(TreeNode root) {
    sum = 0;
    visit(root);
    return root;
  }

  private void visit(TreeNode node) {
    if (node == null) {
      return;
    }

    visit(node.right);
    int val = node.val;
    node.val += sum;
    sum += val;
    visit(node.left);
  }
}
