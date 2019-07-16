package leetcode;

public class Candy {

  private final int MIN_NUM = 1;

  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }

    int[] res = new int[ratings.length];
    for (int i = 0; i < res.length; i++) {
      res[i] = MIN_NUM;
    }

    for (int i = 1; i < res.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        res[i] = res[i - 1] + 1;
      }
    }
    for (int i = res.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
        res[i] = res[i + 1] + 1;
      }
    }

    int sum = 0;
    for (int i = 0; i < res.length; i++) {
      sum += res[i];
    }
    return sum;
  }
}
