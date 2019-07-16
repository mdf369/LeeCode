package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode head2 = new RandomListNode(0);
        RandomListNode node = head;
        RandomListNode node2 = head2;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (node != null) {
            RandomListNode next = new RandomListNode(node.label);
            node2.next = next;
            map.put(node, next);

            node2 = next;
            node = node.next;
        }

        node = head;
        node2 = head2.next;

        while (node != null) {
            if (node.random != null) {
                node2.random = map.get(node.random);
            }

            node = node.next;
            node2 = node2.next;
        }

        return head2.next;
    }
}
