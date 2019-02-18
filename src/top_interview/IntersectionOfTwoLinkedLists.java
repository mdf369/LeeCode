package top_interview;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null && headB != null) {
            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);

            headA = headA.next;
            headB = headB.next;
        }

        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists test = new IntersectionOfTwoLinkedLists();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);

        node2.next = node6;
        node6.next = node4;
        node1.next = node5;

        System.out.println(test.getIntersectionNode(node2, node1));
    }
}
