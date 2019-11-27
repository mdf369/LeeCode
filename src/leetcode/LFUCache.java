package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

  private class Node {
    int key;
    int value;
    long count;
    Node pre;
    Node next;

    public Node(int key, int value, long count) {
      this.key = key;
      this.value = value;
      this.count = count;
      this.pre = this.next = null;
    }
  }

  private int capacity;
  private Map<Integer, Node> map;
  private Node head;
  private Node tail;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();

    head = new Node(0, 0, Long.MAX_VALUE);
    tail = new Node(0, 0, Long.MIN_VALUE);
    head.next = tail;
    tail.pre = head;
  }

  private void removeFromList(Node node) {
    Node pre = node.pre;
    Node next = node.next;

    pre.next = next;
    next.pre = pre;
  }

  private void insertToNext(Node pre, Node node) {
    Node next = pre.next;
    pre.next = node;
    node.pre = pre;
    node.next = next;
    next.pre = node;
  }

  private void evict() {
    if (head.next == tail) {
      return;
    }

    Node last = tail.pre;
    removeFromList(last);
    map.remove(last.key);
  }

  private void update(Node node) {
    node.count++;
    removeFromList(node);

    Node p = node.pre;
    while (p.count <= node.count) {
      p = p.pre;
    }
    insertToNext(p, node);
  }

  public int get(int key) {
    if (capacity < 1 || !map.containsKey(key)) {
      return -1;
    }

    Node node = map.get(key);
    update(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity < 1) {
      return;
    }

    if (map.size() == capacity && !map.containsKey(key)) {
      evict();
    }

    Node node;
    if (map.containsKey(key)) {
      node = map.get(key);
      node.value = value;
    } else {
      node = new Node(key, value, 0);
      insertToNext(tail.pre, node);
    }
    update(node);
    map.put(key, node);
  }
}
