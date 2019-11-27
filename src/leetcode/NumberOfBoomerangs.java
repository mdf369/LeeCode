package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

  private int getDis(int[] p1, int[] p2) {
    return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
  }

  private int getCombinationNum(int n) {
    return n * (n - 1);
  }

  private int calOnePoint(int[][] points, int[] p) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] point : points) {
      int dis = getDis(point, p);
      if (map.containsKey(dis)) {
        map.put(dis, map.get(dis) + 1);
      } else {
        map.put(dis, 1);
      }
    }

    return map.values().stream().mapToInt(this::getCombinationNum).sum();
  }

  public int numberOfBoomerangs(int[][] points) {
    int res = 0;
    for (int[] point : points) {
      res += calOnePoint(points, point);
    }
    return res;
  }
}
