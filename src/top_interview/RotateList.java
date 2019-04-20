package top_interview;

public class RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    int len = getLen(head);
    if (len <= 1) {
      return head;
    }

    k %= len;
    if (k == 0) {
      return head;
    }

    ListNode node = head;
    for (int i = 0; i < len - k - 1; i++) {
      node = node.next;
    }
    ListNode newHead = node.next;
    ListNode tail = getLast(newHead);
    tail.next = head;
    node.next = null;
    return newHead;
  }

  private int getLen(ListNode node) {
    int len = 0;
    while (node != null) {
      node = node.next;
      len++;
    }
    return len;
  }

  private ListNode getLast(ListNode node) {
    while (node != null && node.next != null) {
      node = node.next;
    }
    return node;
  }
}
