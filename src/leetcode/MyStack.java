package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

  private Queue<Integer>[] queues;

  /** Initialize your data structure here. */
  public MyStack() {
    queues = new Queue[2];
    for (int i = 0; i < queues.length; i++) {
      queues[i] = new LinkedList<>();
    }
  }

  private void swap() {
    Queue temp = queues[0];
    queues[0] = queues[1];
    queues[1] = temp;
  }

  private int moveAndGetLast() {
    if (empty()) {
      return Integer.MIN_VALUE;
    }

    while (queues[0].size() > 1) {
      queues[1].add(queues[0].poll());
    }
    int last = queues[0].poll();
    swap();
    return last;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    queues[0].add(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return moveAndGetLast();
  }

  /** Get the top element. */
  public int top() {
    int last = moveAndGetLast();
    queues[0].add(last);
    return last;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queues[0].isEmpty();
  }
}
