package leetcode;

public class ThirdMaximumNumber {

  private boolean isExist(int[] cache, int v, int len) {
    for (int i = 0; i < len; i++) {
      if (cache[i] == v) {
        return true;
      }
    }
    return false;
  }

  private void update(int[] cache, int index) {
    for (int i = index; i > 0; i--) {
      if (cache[i] < cache[i - 1]) {
        break;
      } else {
        int temp = cache[i];
        cache[i] = cache[i - 1];
        cache[i - 1] = temp;
      }
    }
  }

  public int thirdMax(int[] nums) {
    int[] cache = new int[3];
    int count = 0;

    for (int num : nums) {
      if (isExist(cache, num, count)) {
        continue;
      }

      if (count < 3) {
        cache[count] = num;
        update(cache, count);
        count++;
      } else {
        if (cache[2] < num) {
          cache[2] = num;
          update(cache, 2);
        }
      }
    }
    return count == 3 ? cache[count - 1] : cache[0];
  }
}
