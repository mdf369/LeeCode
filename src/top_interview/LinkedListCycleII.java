package top_interview;

public class LinkedListCycleII {

  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode fast, slow;
    fast = slow = head;
    while (true) {
      if (fast.next == null || fast.next.next == null) {
        return null;
      }

      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }

    fast = head;
    while (fast != slow) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
