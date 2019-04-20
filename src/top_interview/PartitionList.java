package top_interview;

public class PartitionList {

  public ListNode partition(ListNode head, int x) {
    ListNode pre = new ListNode(0);
    ListNode after = new ListNode(0);
    ListNode p = pre;
    ListNode q = after;
    while (head != null) {
      if (head.val < x) {
        p.next = head;
        p = p.next;
      } else {
        q.next = head;
        q = q.next;
      }
      head = head.next;
    }

    q.next = null;
    p.next = after.next;
    return pre.next;
  }
}
