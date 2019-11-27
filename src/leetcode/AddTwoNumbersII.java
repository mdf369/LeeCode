package leetcode;

import java.util.Stack;

public class AddTwoNumbersII {

  private void inStack(ListNode node, Stack<Integer> stack) {
    while (node != null) {
      stack.push(node.val);
      node = node.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> longStack = new Stack<>();
    Stack<Integer> shortStack = new Stack<>();
    inStack(l1, longStack);
    inStack(l2, shortStack);
    if (longStack.size() < shortStack.size()) {
      Stack t = longStack;
      longStack = shortStack;
      shortStack = t;
    }

    Stack<Integer> sumStack = new Stack<>();
    int shift = 0;
    while (!longStack.isEmpty()) {
      int sum = longStack.pop() + shift;
      if (!shortStack.isEmpty()) {
        sum += shortStack.pop();
      }

      sumStack.push(sum % 10);
      shift = sum / 10;
    }
    if (shift > 0) {
      sumStack.push(shift);
    }

    ListNode res = new ListNode(0);
    ListNode p = res;
    while (!sumStack.isEmpty()) {
      p.next = new ListNode(sumStack.pop());
      p = p.next;
    }
    return res.next;
  }
}
