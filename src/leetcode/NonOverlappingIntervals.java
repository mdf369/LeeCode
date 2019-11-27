package leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    int count = 0;
    int pre = 0;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= intervals[pre][1]) {
        pre = i;
      } else {
        count++;
        pre = intervals[pre][1] <= intervals[i][1] ? pre : i;
      }
    }
    return count;
  }
}
