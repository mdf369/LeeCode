package leetcode;

public class NumberOfDigitOne {

  public int countDigitOne(int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 10) {
      return 1;
    }

    int degree = (int) Math.log10(n);
    int base = (int) Math.pow(10, degree);
    int high = n / base;
    int rest = n % base;

    int count = high > 1 ? base : rest + 1;
    count += high * countDigitOne(base - 1);
    count += countDigitOne(rest);
    return count;
  }
}
