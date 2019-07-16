package leetcode;

public class ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode preHead = m == 1 ? null : head;
    ListNode right = head;
    for (int i = 2; i < m; i++) {
      preHead = preHead.next;
    }
    for (int i = 1; i < n; i++) {
      right = right.next;
    }

    ListNode left = preHead == null ? head : preHead.next;
    ListNode nextTail = right.next;

    reverse(left, right);
    if (preHead == null) {
      head = right;
    } else {
      preHead.next = right;
    }
    left.next = nextTail;

    return head;
  }

  private void reverse(ListNode start, ListNode end) {
    ListNode next = start.next;
    while (start != end) {
      ListNode temp = next.next;
      next.next = start;
      start = next;
      next = temp;
    }
  }
}
