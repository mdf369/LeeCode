package leetcode;

public class NumberComplement {

  public int findComplement(int num) {
    int mask = 1;
    int t = num;
    while (t > 0) {
      t = t >> 1;
      mask = mask << 1;
    }

    return mask - 1 - num;
  }
}
