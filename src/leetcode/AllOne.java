package leetcode;

import java.util.HashMap;
import java.util.Map;

public class AllOne {

  private class Node {
    String key;
    int value;
    Node pre;
    Node next;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
      pre = next = null;
    }
  }

  private Map<String, Node> map;
  private Node head, tail;

  /** Initialize your data structure here. */
  public AllOne() {
    map = new HashMap<>();

    head = new Node(null, Integer.MIN_VALUE);
    tail = new Node(null, Integer.MAX_VALUE);
    head.next = tail;
    tail.pre = head;
  }

  private boolean isEmpty() {
    return head.next == tail;
  }

  private Node findNewLoc(Node node, boolean inc) {
    Node p = null;
    if (inc) {
      p = node.next;
      while (p != tail && p.next.value < node.value) {
        p = p.next;
      }
    } else {
      p = node.pre;
      while (p != head && p.pre.value > node.value) {
        p = p.pre;
      }
    }
    return p;
  }

  private void remove(Node node) {
    node.next.pre = node.pre;
    node.pre.next = node.next;
  }

  private void move(Node node, Node loc, boolean next) {
    remove(node);

    Node preNode, nextNode;
    if (next) {
      preNode = loc;
      nextNode = loc.next;
    } else {
      preNode = loc.pre;
      nextNode = loc;
    }

    preNode.next = node;
    node.pre = preNode;
    node.next = nextNode;
    nextNode.pre = node;
  }

  private void updateLoc(Node node, boolean inc) {
    if (node.value >= node.pre.value && node.value <= node.next.value) {
      return;
    }

    Node locNode = findNewLoc(node, inc);
    move(node, locNode, inc);
  }

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    if (!map.containsKey(key)) {
      Node node = new Node(key, 1);
      Node next = head.next;
      head.next = node;
      node.pre = head;
      node.next = next;
      next.pre = node;

      map.put(key, node);
    } else {
      Node node = map.get(key);
      node.value++;
      updateLoc(node, true);
    }
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    if (!map.containsKey(key)) {
      return;
    }

    Node node = map.get(key);
    node.value--;

    if (node.value <= 0) {
      map.remove(key);
      remove(node);
    } else {
      updateLoc(node, false);
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    if (isEmpty()) {
      return "";
    } else {
      return tail.pre.key;
    }
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    if (isEmpty()) {
      return "";
    } else {
      return head.next.key;
    }
  }
}
