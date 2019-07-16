package leetcode;

public class UniqueBinarySearchTrees {

  public int numTrees(int n) {
    if (n < 1) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    int[] mem = new int[n + 1];
    mem[0] = mem[1] = 1;
    for (int i = 2; i <= n; i++) {
      mem[i] = getNext(i, mem);
    }
    return mem[n];
  }

  private int getNext(int index, int[] mem) {
    int res = 0;
    boolean flag = ((index - 1) & 1) == 0;
    int limit = index >> 1;

    for (int i = 0; i < limit; i++) {
      res += mem[i] * mem[index - 1 - i];
    }
    res = res << 1;
    if (flag) {
      res += mem[limit] * mem[limit];
    }
    return res;
  }
}
