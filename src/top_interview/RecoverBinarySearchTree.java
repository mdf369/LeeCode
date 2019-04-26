package top_interview;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {

  public void recoverTree(TreeNode root) {
    List<TreeNode> nodeList = new ArrayList<>();
    dfs(root, nodeList);
    int[] pair = getInvertedIndex(nodeList);
    swap(nodeList, pair);
  }

  private void swap(List<TreeNode> nodeList, int[] pair) {
    int t = nodeList.get(pair[0]).val;
    nodeList.get(pair[0]).val = nodeList.get(pair[1]).val;
    nodeList.get(pair[1]).val = t;
  }

  private int[] getInvertedIndex(List<TreeNode> nodeList) {
    int p = 0;
    while (p < nodeList.size() - 1 && nodeList.get(p).val <= nodeList.get(p + 1).val) {
      p++;
    }
    int q = nodeList.size() - 1;
    while (q > 0 && nodeList.get(q - 1).val <= nodeList.get(q).val) {
      q--;
    }
    return new int[]{p, q};
  }

  private void dfs(TreeNode node, List<TreeNode> nodeList) {
    if (node == null) {
      return;
    }
    dfs(node.left, nodeList);
    nodeList.add(node);
    dfs(node.right, nodeList);
  }
}
