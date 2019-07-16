package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    List<Node> nodeList = new ArrayList<>();
    nodeList.add(root);
    while (!nodeList.isEmpty()) {
      List<Node> children = new ArrayList<>();
      Node pre = nodeList.get(0);
      addChild(pre, children);
      for (int i = 1; i < nodeList.size(); i++) {
        Node node = nodeList.get(i);
        pre.next = node;
        pre = node;
        addChild(node, children);
      }
      nodeList = children;
    }
    return root;
  }

  private void addChild(Node node, List<Node> children) {
    if (node.left != null) {
      children.add(node.left);
    }
    if (node.right != null) {
      children.add(node.right);
    }
  }
}
