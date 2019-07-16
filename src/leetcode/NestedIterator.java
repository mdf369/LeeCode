package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

  private Deque<NestedInteger> queue;

  public NestedIterator(List<NestedInteger> nestedList) {
    queue = new ArrayDeque<>();
    updateStackByList(nestedList, false);
  }

  @Override
  public Integer next() {
    return queue.poll().getInteger();
  }

  @Override
  public boolean hasNext() {
    checkStack();
    return !queue.isEmpty();
  }

  private void updateStackByList(List<NestedInteger> list, boolean first) {
    if (list == null) {
      return;
    }
    if (!first) {
      for (NestedInteger nestedInteger : list) {
        queue.add(nestedInteger);
      }
    } else {
      for (int i = list.size() - 1; i >= 0; i--) {
        queue.addFirst(list.get(i));
      }
    }
  }

  private void checkStack() {
    while (true) {
      if (queue.isEmpty()) {
        return;
      }

      NestedInteger next = queue.peek();
      if (next.isInteger()) {
        return;
      } else {
        queue.poll();
        updateStackByList(next.getList(), true);
      }
    }
  }
}

