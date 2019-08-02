package leetcode;

public class BulbSwitcher {

  public int bulbSwitch(int n) {
    int num = 0;
    for (int i = 1; i <= n; i++) {
      int factor = (int) Math.sqrt(i);
      if (factor * factor == i) {
        num++;
      }
    }
    return num;
  }
}
