package leetcode;

public class SelfCrossing {

  public boolean isSelfCrossing(int[] x) {
    if (x == null || x.length < 4) {
      return false;
    }

    int index = 2;
    while (index < x.length) {
      if (x[index] <= x[index - 2]) {
        break;
      }
      index++;
    }

    index++;

    if (index < x.length && index >= 4) {
      if (x[index - 3] == x[index - 1] && x[index - 2] <= x[index - 4] + x[index]) {
        return true;
      }
    }
    if (index < x.length && index >= 5) {
      int h = x[index - 3];
      int h2 = x[index - 5];
      int h3 = x[index - 1];
      int w = x[index - 2];
      int w1 = x[index - 4];
      int w2 = x[index];

      if (h2 + h3 >= h && w1 + w2 >= w) {
        return true;
      }
    }

    while (index < x.length) {
      if (x[index] >= x[index - 2]) {
        return true;
      }
      index++;
    }
    return false;
  }
}
