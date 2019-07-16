package leetcode;

public class ConvertSortedListToBinarySearchTree {

  public TreeNode sortedListToBST(ListNode head) {
    return sortedListToBST(head, null);
  }

  private TreeNode sortedListToBST(ListNode start, ListNode end) {
    if (start == null || start == end) {
      return null;
    }

    ListNode middle = getMiddle(start, end);
    TreeNode parent = new TreeNode(middle.val);
    parent.left = sortedListToBST(start, middle);
    parent.right = sortedListToBST(middle.next, end);
    return parent;
  }

  private ListNode getMiddle(ListNode start, ListNode end) {
    ListNode p = start;
    ListNode q = start;

    while (q != end && q.next != end) {
      p = p.next;
      q = q.next.next;
    }

    return p;
  }
}
