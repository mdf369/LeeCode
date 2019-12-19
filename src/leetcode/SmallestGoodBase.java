package leetcode;

public class SmallestGoodBase {

  private long getSum(long k, long m) {
    long sum = 0;
    for (int i = 0; i < m; i++) {
      sum = sum * k + 1;
    }
    return sum;
  }

  private long isGoodBase(long n, long m) {
    long left = 2;
    long right = (long) (Math.pow(n, 1.0 / (m - 1)) + 1);
    while (left < right) {
      long middle = left + (right - left) / 2;
      long sum = getSum(middle, m);
      if (sum == n) {
        return middle;
      } else if (sum < n) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }
    return -1;
  }

  public String smallestGoodBase(String n) {
    long nv = Long.parseLong(n);
    for (int i = (int) (Math.log(nv + 1) / Math.log(2)); i >= 2; i--) {
      long k = isGoodBase(nv, i);
      if (k >= 0) {
        return String.valueOf(k);
      }
    }
    return String.valueOf(nv - 1);
  }
}
