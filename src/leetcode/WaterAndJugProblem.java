package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WaterAndJugProblem {

  public boolean canMeasureWater(int x, int y, int z) {
    if (z > x + y || z < 0) {
      return false;
    }

    return go(0, 0, x, y, z, new HashMap<>());
  }

  private boolean go(int cx, int cy, int x, int y, int z, Map<Integer, Set<Integer>> visitedSet) {
    if (visited(cx, cy, visitedSet)) {
      return false;
    }
    if (cx + cy == z) {
      return true;
    }

    if (go(0, cy, x, y, z, visitedSet)) {
      return true;
    }
    if (go(cx, 0, x, y, z, visitedSet)) {
      return true;
    }
    if (go(x, cy, x, y, z, visitedSet)) {
      return true;
    }
    if (go(cx, y, x, y, z, visitedSet)) {
      return true;
    }

    int nextx, nexty;
    if (cx > y - cy) {
      nextx = cx - (y - cy);
      nexty = y;
    } else {
      nextx = 0;
      nexty = cy + cx;
    }
    if (go(nextx, nexty, x, y, z, visitedSet)) {
      return true;
    }

    if (cy > x - cx) {
      nexty = cy - (x - cx);
      nextx = x;
    } else {
      nexty = 0;
      nextx = cx + cy;
    }
    if (go(nextx, nexty, x, y, z, visitedSet)) {
      return true;
    }

    return false;
  }

  private boolean visited(int cx, int cy, Map<Integer, Set<Integer>> visitedSet) {
    if (visitedSet.containsKey(cx) && visitedSet.get(cx).contains(cy)) {
      return true;
    }

    if (visitedSet.containsKey(cx)) {
      visitedSet.get(cx).add(cy);
    } else {
      Set<Integer> set = new HashSet<>();
      set.add(cy);
      visitedSet.put(cx, set);
    }
    return false;
  }
}
