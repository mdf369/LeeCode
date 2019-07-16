package leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

  private class Node {

    String key;
    private double value;
    private Node father;

    public Node(String key, double value) {
      this.key = key;
      this.value = value;
      this.father = null;
    }

    @Override
    public String toString() {
      return key;
    }
  }

  public double[] calcEquation(List<List<String>> equations, double[] values,
      List<List<String>> queries) {
    Map<String, Node> map = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String a = equations.get(i).get(0);
      String b = equations.get(i).get(1);
      boolean aExist = map.containsKey(a);
      boolean bExist = map.containsKey(b);

      Node aNode;
      Node bNode;
      if (!aExist && !bExist) {
        aNode = new Node(a, values[i]);
        bNode = new Node(b, 1);
        bNode.father = aNode;
      } else if (aExist && !bExist) {
        aNode = map.get(a);
        bNode = new Node(b, aNode.value / values[i]);
        bNode.father = aNode;
      } else if (!aExist && bExist) {
        bNode = map.get(b);
        aNode = new Node(a, bNode.value * values[i]);
        aNode.father = bNode;
      } else {
        aNode = map.get(a);
        bNode = map.get(b);
        union(aNode, bNode, values[i], map.values());
      }

      if (!aExist) {
        map.put(a, aNode);
      }
      if (!bExist) {
        map.put(b, bNode);
      }
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String a = queries.get(i).get(0);
      String b = queries.get(i).get(1);

      Node aNode = map.get(a);
      Node bNode = map.get(b);
      if (aNode != null && bNode != null && findFather(aNode) == findFather(bNode)) {
        res[i] = aNode.value / bNode.value;
      } else {
        res[i] = -1.0;
      }
    }
    return res;
  }

  private Node findFather(Node node) {
    while (node.father != null) {
      node = node.father;
    }
    return node;
  }

  private void union(Node aNode, Node bNode, double value, Collection<Node> nodeSet) {
    Node aFather = findFather(aNode);
    Node bFather = findFather(bNode);
    double ratio = bNode.value / aNode.value * value;

    for (Node node : nodeSet) {
      if (findFather(node) == aFather) {
        node.value *= ratio;
      }
    }
    bFather.father = aFather;
  }
}
