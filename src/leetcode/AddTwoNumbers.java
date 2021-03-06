package leetcode;

public class AddTwoNumbers {

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int shift = 0;
        int currentV;
        ListNode root = new ListNode(-1);
        ListNode next = root;

        while (l1 != null && l2 != null){
            currentV = l1.val + l2.val + shift;
            shift = currentV / 10;
            ListNode current = new ListNode(currentV % 10);
            next.next = current;

            next = current;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null){
            ListNode rest = l1 != null? l1 : l2;
            while (rest != null) {
                currentV = rest.val + shift;
                shift = currentV / 10;
                ListNode current = new ListNode(currentV % 10);
                next.next = current;

                next = current;
                rest = rest.next;
            }
        }

        if(shift > 0){
            ListNode current = new ListNode(shift);
            next.next = current;
        }

        return root.next;
    }

    private void displayListNode(ListNode node){
        StringBuilder builder = new StringBuilder();
        while (node != null){
            builder.append(node.val + " -> ");
            node = node.next;
        }
        System.out.println(builder.toString());
    }
}
