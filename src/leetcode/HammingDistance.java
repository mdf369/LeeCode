package leetcode;

public class HammingDistance {

  public int hammingDistance(int x, int y) {
    int len = 31;
    int count = 0;
    x = x ^ y;
    for (int i = 0; i < len; i++) {
      if ((x & 1) == 1) {
        count++;
      }
      x = x >> 1;
    }
    return count;
  }
}
