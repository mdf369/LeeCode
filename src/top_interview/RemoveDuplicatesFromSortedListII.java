package top_interview;

public class RemoveDuplicatesFromSortedListII {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode node = new ListNode(0);
    node.next = head;
    ListNode root = node;
    while (node.next != null) {
      ListNode next = getNextUnequal(node);
      if (next.next != node.next.next) {
        node.next = next.next;
      }
      node = next;
    }
    return root.next;
  }

  private ListNode getNextUnequal(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }

    if (node.next.next == null || node.next.val != node.next.next.val) {
      return node.next;
    }

    int pre = node.next.val;
    while (node.next != null) {
      if (node.next.val != pre) {
        if (node.next.next == null) {
          return node;
        } else {
          if (node.next.val == node.next.next.val) {
            pre = node.next.val;
          } else {
            return node;
          }
        }
      }
      node = node.next;
    }
    return node;
  }
}
