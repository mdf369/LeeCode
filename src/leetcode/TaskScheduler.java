package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskScheduler {

  public int leastInterval(char[] tasks, int n) {
    if (tasks == null) {
      return 0;
    }

    Integer[] counts = new Integer[26];
    for (int i = 0; i < counts.length; i++) {
      counts[i] = 0;
    }
    for (int i = 0; i < tasks.length; i++) {
      counts[tasks[i] - 'A']++;
    }
    Arrays.sort(counts, 0, counts.length, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });

    List<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < counts.length; i++) {
      update(indexList, counts[i], n);
    }

    int idleNum = 0;
    for (int i = 0; i < indexList.size() - 1; i++) {
      idleNum += n + 1 - indexList.get(i);
    }

    return idleNum + tasks.length;
  }

  private void update(List<Integer> list, int count, int n) {
    for (int i = 0; i < count; i++) {
      if (i >= list.size()) {
        list.add(1);
      } else {
        list.set(i, list.get(i) + 1);
      }
    }

    while (!list.isEmpty() && list.get(0) == n + 1) {
      list.remove(0);
    }
  }
}
