package leetcode;

import java.util.Random;

public class LinkedListRandomNode {

  private ListNode head;
  private Random random;

  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public LinkedListRandomNode(ListNode head) {
    this.head = head;
    random = new Random(System.currentTimeMillis());
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode res = head;
    ListNode cur = head.next;
    int size = 2;
    while (cur != null) {
      int v = random.nextInt(size);
      if (v == 0) {
        res = cur;
      }
      size++;
      cur = cur.next;
    }
    return res.val;
  }
}
