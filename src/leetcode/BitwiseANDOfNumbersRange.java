package leetcode;

public class BitwiseANDOfNumbersRange {

  public int rangeBitwiseAnd(int m, int n) {
    if (m == 0 && n == 0) {
      return 0;
    }
    return 0;
  }

  private int getTwoPow(int n) {
    int base = 1;
    while (n > base) {
      base = base << 1;
    }
    return base;
  }
}
