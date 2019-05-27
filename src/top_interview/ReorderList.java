package top_interview;

public class ReorderList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return;
    }

    ListNode middle = getMiddle(head);
    go(head, middle);
  }

  private ListNode go(ListNode left, ListNode right) {
    if (right.next != null) {
      left = go(left, right.next);
    }

    if (left == right) {
      left.next = null;
      return null;
    } else {
      ListNode next = left.next;
      left.next = right;
      right.next = right == next ? null : next;
      return next;
    }
  }

  private ListNode getMiddle(ListNode head) {
    ListNode p = head;
    ListNode pp = head;

    while (pp != null && pp.next != null) {
      p = p.next;
      pp = pp.next.next;
    }
    return p;
  }
}
