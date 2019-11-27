package leetcode;

import java.util.Arrays;

public class Heaters {

  private int getNearestHeater(int house, int[] heaters, int index) {
    int min = Math.abs(house - heaters[index]);
    while (index + 1 < heaters.length) {
      if (Math.abs(house - heaters[index + 1]) <= min) {
        min = Math.abs(house - heaters[index + 1]);
        index++;
      } else {
        break;
      }
    }
    return index;
  }

  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);

    int min = 0;
    int heaterIndex = 0;
    for (int house : houses) {
      heaterIndex = getNearestHeater(house, heaters, heaterIndex);
      min = Math.max(min, Math.abs(house - heaters[heaterIndex]));
    }
    return min;
  }
}
