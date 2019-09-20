package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

  private int getHour(int time) {
    return time >> 6;
  }

  private int getMinute(int time) {
    return time & ((1 << 6) - 1);
  }

  private boolean isValid(int hour, int minute) {
    return hour < 12 && minute < 60;
  }

  private void go(int time, int start, int num, List<String> res) {
    if (num == 0) {
      int hour = getHour(time);
      int minute = getMinute(time);
      if (isValid(hour, minute)) {
        res.add(String.format("%d:%02d", hour, minute));
      }
    }

    for (int i = start; i < 10; i++) {
      go(time + (1 << i), i + 1, num - 1, res);
    }
  }

  public List<String> readBinaryWatch(int num) {
    List<String> res = new ArrayList<>();

    go(0, 0, num, res);
    return res;
  }
}
