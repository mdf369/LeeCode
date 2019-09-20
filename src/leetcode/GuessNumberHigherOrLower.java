package leetcode;

public class GuessNumberHigherOrLower {

  private int guess(int num) {
    int value = 1049889538;
    if (num > value) {
      return -1;
    } else if (num < value) {
      return 1;
    } else {
      return 0;
    }
  }

  public int guessNumber(int n) {
    int left = 1;
    int right = n + 1;
    while (true) {
      int middle = left + (right - left) / 2;
      int res = guess(middle);
      if (res == 0) {
        return middle;
      } else {
        if (res < 0) {
          left = middle + 1;
        } else {
          right = middle;
        }
      }
    }
  }
}
