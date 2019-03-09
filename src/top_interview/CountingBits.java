package top_interview;

import java.util.ArrayList;
import java.util.List;

public class CountingBits {

  public int[] countBits(int num) {
    if (num < 0) {
      return null;
    }

    int[] res = new int[num + 1];
    List<Integer> mem = new ArrayList<>();
    int limit = 1;
    int index = 0;
    int shift = 0;
    boolean back = false;
    for (int i = 1; i <= num; i++) {
      if (i == limit) {
        mem.add(1);
        res[i] = 1;
        limit *= 2;
        index = 0;
        shift = 1;
        back = true;
      } else {
        if (index >= mem.size()) {
          index = 0;
          shift++;
          back = true;
        }
        res[i] = mem.get(index) + shift;
        if (back) {
          mem.add(mem.get(index) + shift);
        }
        index++;
      }
    }
    return res;
  }
}
