package leetcode;

public class PermutationSequence {

  public String getPermutation(int n, int k) {
    int[] mem = new int[n];
    StringBuilder builder = new StringBuilder();
    go(builder, mem, k - 1, getMult(n - 1), n - 1);
    return builder.toString();
  }

  private void go(StringBuilder builder, int[] mem, int k, int chu, int index) {
    int num = getK(mem, k / chu);
    builder.append(num);
    if (index <= 0) {
      return;
    }
    go(builder, mem, k % chu, chu / index, index - 1);
  }

  private int getK(int[] mem, int k) {
    int count = 0;
    for (int i = 0; i < mem.length; i++) {
      if (mem[i] == -1) {
        continue;
      }
      if (count == k) {
        mem[i] = -1;
        return i + 1;
      }
      count++;
    }
    return -1;
  }

  private int getMult(int n) {
    int res = 1;
    for (int i = 1; i <= n; i++) {
      res *= i;
    }
    return res;
  }
}
