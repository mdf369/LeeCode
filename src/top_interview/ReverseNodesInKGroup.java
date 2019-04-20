package top_interview;

import com.sun.org.apache.regexp.internal.RE;
import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k < 2 || !isValid(head, k)) {
      return head;
    }

    ListNode res = getNode(head, k);

    ListNode a = head;
    ListNode an = a.next;
    ListNode ann = an.next;
    ListNode pre = null;
    ListNode start;
    while (true) {
      start = a;
      for (int i = 0; i < k - 1; i++) {
        an.next = a;
        a = an;
        an = ann;
        if (an != null) {
          ann = an.next;
        }
      }
      start.next = an;
      if (pre != null) {
        pre.next = a;
      }
      pre = start;
      a = an;
      if (isValid(a, k)) {
        an = a.next;
        ann = an.next;
      } else {
        break;
      }
    }
    return res;
  }

  private ListNode getNode(ListNode start, int k) {
    for (int i = 0; i < k - 1; i++) {
      start = start.next;
    }
    return start;
  }

  private boolean isValid(ListNode node, int k) {
    for (int i = 0; i < k; i++) {
      if (node == null) {
        return false;
      }
      node = node.next;
    }
    return true;
  }
}
