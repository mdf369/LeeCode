package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) {
      res.add(newInterval);
      return res;
    }

    if (newInterval.start > intervals.get(intervals.size() - 1).end) {
      intervals.add(newInterval);
      return intervals;
    }
    if (newInterval.end < intervals.get(0).start) {
      intervals.add(0, newInterval);
      return intervals;
    }

    int[] range = getOverlappingRange(intervals, newInterval);
    for (int i = 0; i < range[0]; i++) {
      res.add(intervals.get(i));
    }
    Interval interval = new Interval(Math.min(intervals.get(range[0]).start, newInterval.start),
        Math.max(intervals.get(range[1]).end, newInterval.end));
    res.add(interval);
    for (int i = range[1] + 1; i < intervals.size(); i++) {
      res.add(intervals.get(i));
    }
    return res;
  }

  private int[] getOverlappingRange(List<Interval> intervalList, Interval newInterval) {
    int[] range = new int[2];
    for (int i = 0; i < intervalList.size(); i++) {
      if (intervalList.get(i).end >= newInterval.start) {
        range[0] = i;
        break;
      }
    }
    for (int i = intervalList.size() - 1; i >= 0; i--) {
      if (intervalList.get(i).start <= newInterval.end) {
        range[1] = i;
        break;
      }
    }
    return range;
  }
}
