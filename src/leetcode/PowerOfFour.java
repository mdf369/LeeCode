package leetcode;

public class PowerOfFour {

  public boolean isPowerOfFour(int num) {
    while (num > 0) {
      if (num == 1) {
        return true;
      }

      if (num % 4 != 0) {
        return false;
      }
      num = num >> 2;
    }
    return false;
  }
}
