package top_interview;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        while (node != null) {
            ListNode next = node.next;
            node.val = next.val;

            if (next.next == null) {
                node.next = null;
                break;
            }

            node = next;
        }
    }
}
