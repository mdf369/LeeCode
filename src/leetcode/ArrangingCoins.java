package leetcode;

public class ArrangingCoins {

  public int arrangeCoins(int n) {
    long nn = ((long) n) << 1;
    long base = (int) Math.sqrt(nn);
    if (base * (base + 1) > nn) {
      base--;
    }
    return (int) base;
  }
}
