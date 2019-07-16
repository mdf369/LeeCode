package leetcode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length) {
      return null;
    }

    return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }

  private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
    if (iend - istart != pend - pstart || istart >= iend) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[pend - 1]);
    int index = find(inorder, istart, iend, root.val);
    int leftLen = index - istart;
    int rightLen = iend - index - 1;
    root.left = buildTree(inorder, istart, index, postorder, pstart, pstart + leftLen);
    root.right = buildTree(inorder, index + 1, iend, postorder, pend - 1 - rightLen, pend - 1);
    return root;
  }

  private int find(int[] nums, int start, int end, int target) {
    for (int i = start; i < end; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
