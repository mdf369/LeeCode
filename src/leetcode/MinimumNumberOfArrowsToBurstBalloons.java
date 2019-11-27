package leetcode;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

  private int getNextArrow(int[][] points, int index) {
    int arrow = points[index][1];
    while (index < points.length && points[index][0] < arrow) {
      arrow = Math.min(arrow, points[index][1]);
      index++;
    }
    return arrow;
  }

  public int findMinArrowShots(int[][] points) {
    if (points == null) {
      return 0;
    }

    Arrays.sort(points, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    int res = 0;
    int index = 0;
    while (index < points.length) {
      int arrow = getNextArrow(points, index);
      res++;
      while (index < points.length && points[index][0] <= arrow) {
        index++;
      }
    }
    return res;
  }
}
