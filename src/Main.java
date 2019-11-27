import java.util.Stack;

public class Main {

  private static class ListNode {
    int value;
    ListNode next;

    public ListNode(int v) {
      value = v;
      next = null;
    }
  }

  private static ListNode reverse(ListNode node) {
    if(node == null) {
      return null;
    }

    Stack<ListNode> stack = new Stack<>();
    while (node != null) {
      stack.push(node);
      System.out.print(node.value);
      node = node.next;
    }
    ListNode root = stack.peek();
    ListNode p = root;
    while (!stack.isEmpty()) {
      p.next = stack.pop();
      p = p.next;
    }
    p.next = null;
    return root;
  }

  public static void main(String[] args) {
    ListNode[] nodes = new ListNode[5];
    System.out.println("start");
    for (int i = 0;i < 5;i++) {
      nodes[i] = new ListNode(i + 1);
    }
    for (int i = 0;i < 4;i++) {
      nodes[i].next = nodes[i + 1];
    }

    System.out.println("start reverse");
    ListNode root = reverse(nodes[0]);
    while (root != null) {
      System.out.print(root.value + "->");
      root = root.next;
    }
  }
}