package leetcode;

public class CountNumbersWithUniqueDigits {

  public int countNumbersWithUniqueDigits(int n) {
    if (n <= 0) {
      return 1;
    }
    if (n == 1) {
      return 10;
    }

    int res = 10;
    int shift = 9;
    for (int i = 1; i < n; i++) {
      shift *= 10 - i;
      res += shift;
    }
    return res;
  }
}
