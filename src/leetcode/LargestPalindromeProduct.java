package leetcode;

public class LargestPalindromeProduct {

  private boolean checkV(long v, long min, long max) {
    return min <= v && v <= max;
  }

  private boolean check(long pro, long vMin, long vMax) {
    long v = vMax;
    while (v >= vMin && v * v >= pro) {
      if (pro % v == 0 && checkV(pro / v, vMin, vMax)) {
        return true;
      }
      v--;
    }
    return false;
  }

  private long getCon(long count) {
    int n = 0;
    while (count > 0 && count % 10 == 0) {
      n++;
      count /= 10;
    }
    return (long) Math.pow(10, n);
  }

  public int largestPalindrome(int n) {
    long vMin = (long) Math.pow(10, n - 1);
    long vMax = (long) (Math.pow(10, n) - 1);
    long productMin = (long) Math.pow(10, 2 * n - 2);
    long productMiddle = (long) Math.pow(10, 2 * n - 1);
    long productMax = (long) Math.pow(10, 2 * n) - 1;
    long curPro = productMax;
    for (int i = 0; i < 2; i++) {
      long shift;
      if (i == 0) {
        shift = (long) (Math.pow(10, n) + Math.pow(10, n - 1));
      } else {
        shift = (long) Math.pow(10, (2 * n - 1) / 2);
      }

      long count = 0;
      while ((i == 0 && curPro >= productMiddle) || (i == 1 && curPro >= productMin)) {
        if (check(curPro, vMin, vMax)) {
          return (int) (curPro % 1337);
        }

        count++;
        curPro -= shift / getCon(count) + i * shift;
      }

      curPro = productMiddle - 1;
    }

    return -1;
  }
}
