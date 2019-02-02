package top_interview;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        ListNode p = next;
        while (p != null){
            builder.append("->" + p.val);
            p = p.next;
        }
        return builder.toString();
    }
}
