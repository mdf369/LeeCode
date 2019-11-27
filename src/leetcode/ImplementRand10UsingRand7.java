package leetcode;

public class ImplementRand10UsingRand7 {

  public int rand7() {
    return (int) (Math.random() % 7 + 1);
  }

  public int rand10() {
    int shift = -1;
    while (shift == -1) {
      int v = rand7();
      if (v == 7) {
        continue;
      }

      shift = v % 2;
    }

    int v = 7;
    while (v > 5) {
      v = rand7();
    }

    return v * 2 - shift;
  }
}
