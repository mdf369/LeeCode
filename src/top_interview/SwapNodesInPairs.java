package top_interview;

public class SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    if (!isValid(head)) {
      return head;
    }

    ListNode res = head.next;

    ListNode a = head;
    ListNode b = a.next;
    ListNode next = b.next;
    ListNode pre = null;
    while (true) {
      if (pre != null) {
        pre.next = b;
      }
      b.next = a;
      a.next = next;

      pre = a;
      a = pre.next;
      if (isValid(a)) {
        b = a.next;
        next = b.next;
      } else {
        break;
      }
    }
    return res;
  }

  private boolean isValid(ListNode node) {
    if (node == null || node.next == null) {
      return false;
    } else {
      return true;
    }
  }
}
