package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

  public Node cloneGraph(Node node) {
    return cloneGraph(node, new HashMap<>());
  }

  private Node cloneGraph(Node oldNode, Map<Node, Node> map) {
    if (map.containsKey(oldNode)) {
      return map.get(oldNode);
    }

    Node newNode = new Node();
    map.put(oldNode, newNode);

    List<Node> oldList = oldNode.neighbors;
    List<Node> newList = new ArrayList<>(oldList.size());
    for (int i = 0; i < oldList.size(); i++) {
      newList.add(cloneGraph(oldList.get(i), map));
    }

    newNode.val = oldNode.val;
    newNode.neighbors = newList;
    return newNode;
  }

  private class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
