package leetcode;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindRightInterval {

  public int[] findRightInterval(int[][] intervals) {
    Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
    int[] res = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      map.put(intervals[i][0], i);
    }

    for (int i = 0; i < intervals.length; i++) {
      int pre = -1;
      for (Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getKey() < intervals[i][1]) {
          break;
        } else {
          pre = entry.getValue();
        }
      }
      res[i] = pre;
    }
    return res;
  }
}
