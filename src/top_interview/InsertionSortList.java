package top_interview;

public class InsertionSortList {

  public ListNode insertionSortList(ListNode head) {
    ListNode root = new ListNode(0);

    while (head != null) {
      ListNode node = head;
      head = head.next;
      add(root, node);
    }
    return root.next;
  }

  private void add(ListNode root, ListNode node) {
    while (root.next != null && root.next.val < node.val) {
      root = root.next;
    }
    node.next = root.next;
    root.next = node;
  }
}
