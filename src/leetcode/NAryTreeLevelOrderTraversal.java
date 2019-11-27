package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }

    Queue<Node> currentLevel = new LinkedList<>();
    Queue<Node> nextLevel = new LinkedList<>();
    currentLevel.add(root);

    List<List<Integer>> res = new ArrayList<>();
    while (!currentLevel.isEmpty()) {
      List<Integer> line = new ArrayList<>();
      while (!currentLevel.isEmpty()) {
        Node node = currentLevel.poll();
        line.add(node.val);
        if (node.children != null) {
          nextLevel.addAll(node.children);
        }
      }

      res.add(line);
      Queue<Node> temp = currentLevel;
      currentLevel = nextLevel;
      nextLevel = temp;
    }

    return res;
  }
}
