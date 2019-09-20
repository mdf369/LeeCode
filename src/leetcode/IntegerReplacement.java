package leetcode;

public class IntegerReplacement {

  private int getShift(long n) {
    if (n < 4) {
      return -1;
    }
    return (n & 3) == 3 ? 1 : -1;
  }

  public int integerReplacement(int n) {
    long num = n;
    int count = 0;
    while (num != 1) {
      if ((num & 1) == 0) {
        num /= 2;
      } else {
        num += getShift(num);
      }
      count++;
    }
    return count;
  }
}
