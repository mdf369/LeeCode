package top_interview;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode(0);
        root.next = head;

        partition(root, null);

        return root.next;
    }

    private void partition(ListNode root, ListNode tail) {
        if (root == null || root.next == null || root.next == tail) {
            return;
        }

        ListNode target = root.next;
        int targetV = target.val;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode node1 = left;
        ListNode node2 = right;

        ListNode node = root.next.next;
        while (node != tail) {
            if (node.val < targetV) {
                node1.next = node;
                node1 = node1.next;
                node = node.next;
                node1.next = null;
            } else {
                node2.next = node;
                node2 = node2.next;
                node = node.next;
                node2.next = null;
            }
        }

        if (left.next != null) {
            root.next = left.next;
            node1.next = target;
            target.next = right.next;
        } else {
            root.next.next = right.next;
        }
        if (right.next != null) {
            node2.next = tail;
        } else {
            target.next = tail;
        }

        partition(root, target);
        partition(target, tail);
    }
}
