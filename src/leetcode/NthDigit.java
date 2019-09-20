package leetcode;

public class NthDigit {

  private int getDegree(int n) {
    int degree = 1;
    long max = 9;
    long count = 9;
    while (count < n) {
      degree++;
      max *= 10;
      count += max * degree;
    }
    return degree;
  }

  private int getNthDigit(int num, int n) {
    for (int i = 0; i < n; i++) {
      num /= 10;
    }
    return num % 10;
  }

  public int findNthDigit(int n) {
    int degree = getDegree(n);

    int pre = 0;
    int base = 1;
    for (int i = 1; i < degree; i++) {
      pre += 9 * base * i;
      base *= 10;
    }
    n -= pre;

    n--;
    return getNthDigit(base + n / degree, degree - 1 - n % degree);
  }
}
