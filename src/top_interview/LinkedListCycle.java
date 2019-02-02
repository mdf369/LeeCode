package top_interview;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode target = new ListNode(0);

        ListNode node = head;
        while (head != null) {
            if (head.next == target) {
                return true;
            }

            node = head.next;
            head.next = target;
            head = node;
        }
        return false;
    }
}
