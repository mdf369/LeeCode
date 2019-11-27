package leetcode;

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

  static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
      val = _val;
      prev = _prev;
      next = _next;
      child = _child;
    }
  }

  public Node flatten(Node head) {
    Node root = new Node();
    Node p = root;
    Node cur = head;

    Stack<Node> stack = new Stack<>();
    while (cur != null) {
      p.next = cur;
      cur.prev = p;
      p = p.next;

      if (cur.child != null) {
        if (cur.next != null) {
          stack.push(cur.next);
        }
        cur = cur.child;
      } else {
        cur = cur.next;
        if (cur == null && !stack.isEmpty()) {
          cur = stack.pop();
        }
      }

      p.child = null;
    }

    Node res = root.next;
    if (res != null) {
      res.prev = null;
    }
    return res;
  }

  public static void display(Node node) {
    StringBuilder builder = new StringBuilder();
    while (node != null) {
      builder.append(node.val + " -> ");
      node = node.next;
    }
    System.out.println(builder.toString());
  }
}
