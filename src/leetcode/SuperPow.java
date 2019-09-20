package leetcode;

public class SuperPow {

  private final int BASE = 1337;

  private int pow(int x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x % BASE;
    }
    return pow(x % 1337, n / 2) * pow(x % 1337, n - n / 2) % 1337;
  }

  public int superPow(int a, int[] b) {
    a = a % BASE;

    long res = 1;
    for (int i = 0; i < b.length; i++) {
      res = pow((int) res, 10) * pow(a, b[i]) % BASE;
    }
    return (int) res;
  }
}
