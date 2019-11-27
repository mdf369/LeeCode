package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

  private boolean isValid(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count++;
      }

      if (count > 1) {
        return false;
      }
    }
    return true;
  }

  private void enQueue(Queue<Integer> queue, int[] visited, int v) {
    if (visited[v] == 0) {
      queue.add(v);
      visited[v] = 1;
    }
  }

  public int minMutation(String start, String end, String[] bank) {
    int len = bank.length;

    Set<Integer> startSet = new HashSet<>();
    for (int i = 0; i < len; i++) {
      if (isValid(start, bank[i])) {
        startSet.add(i);
      }
    }
    if (start.isEmpty()) {
      return -1;
    }

    int endIndex = -1;
    for (int i = 0; i < len; i++) {
      if (end.endsWith(bank[i])) {
        endIndex = i;
        break;
      }
    }
    if (endIndex == -1) {
      return -1;
    }

    Set<Integer>[] mem = new Set[len];
    for (int i = 0; i < len; i++) {
      mem[i] = new HashSet<>();
    }
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (isValid(bank[i], bank[j])) {
          mem[i].add(j);
          mem[j].add(i);
        }
      }
    }

    int depth = 0;
    int[] visited = new int[len];
    Queue<Integer> curQueue = new LinkedList<>();
    enQueue(curQueue, visited, endIndex);
    Queue<Integer> nextQueue = new LinkedList<>();
    while (!curQueue.isEmpty()) {
      while (!curQueue.isEmpty()) {
        int index = curQueue.poll();
        if (startSet.contains(index)) {
          return depth + 1;
        }

        for (Integer nextIndex : mem[index]) {
          enQueue(nextQueue, visited, nextIndex);
        }
      }

      curQueue.addAll(nextQueue);
      nextQueue.clear();
      depth++;
    }

    return -1;
  }
}
