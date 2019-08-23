package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DataStreamAsDisjointIntervals {

  List<int[]> intervalList;

  /** Initialize your data structure here. */
  public DataStreamAsDisjointIntervals() {
    intervalList = new ArrayList<>();
  }

  public void addNum(int val) {
    if (intervalList.isEmpty()) {
      intervalList.add(new int[]{val, val});
      return;
    }

    int index = getIndexOfOverlappedIntarval(val, 0, intervalList.size());
    if (index < 0) {
      intervalList.add(0, new int[]{val, val});
      return;
    }
    if (index >= intervalList.size()) {
      intervalList.add(new int[]{val, val});
      return;
    }
    int status = getStatus(intervalList.get(index), val);

    if (status == -1) {
      intervalList.add(index, new int[]{val, val});
    } else if (status == 1) {
      intervalList.add(index + 1, new int[]{val, val});
    } else {
      int[] interval = intervalList.get(index);
      if (val == interval[0] - 1) {
        if (index - 1 >= 0 && intervalList.get(index - 1)[1] + 1 == val) {
          merge(index - 1);
        } else {
          interval[0] = val;
        }
      } else if (val == interval[1] + 1) {
        if (index + 1 < intervalList.size() && intervalList.get(index + 1)[0] - 1 == val) {
          merge(index);
        } else {
          interval[1] = val;
        }
      }
    }
  }

  private void merge(int index) {
    int[] interval1 = intervalList.remove(index);
    int[] interval2 = intervalList.remove(index);

    int[] interval = new int[]{interval1[0], interval2[1]};
    intervalList.add(index, interval);
  }

  private int getIndexOfOverlappedIntarval(int num, int start, int end) {
    if (start >= end) {
      return start;
    }

    int middle = (start + end) / 2;
    int status = getStatus(intervalList.get(middle), num);
    if (status == 0) {
      return middle;
    } else if (status == -1) {
      return getIndexOfOverlappedIntarval(num, start, middle);
    } else {
      return getIndexOfOverlappedIntarval(num, middle + 1, end);
    }
  }

  private int getStatus(int[] interval, int num) {
    if (interval[0] - 1 > num) {
      return -1;
    } else if (interval[1] + 1 < num) {
      return 1;
    } else {
      return 0;
    }
  }

  public int[][] getIntervals() {
    int[][] res = new int[intervalList.size()][2];
    return intervalList.toArray(res);
  }
}
