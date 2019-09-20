package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PerfectRectangle {

  private long getSize(int[] rectangle) {
    return (rectangle[2] - rectangle[0]) * (long)(rectangle[3] - rectangle[1]);
  }

  private boolean addVertex(Map<Integer, Map<Integer, Integer>> vertexMap, int x, int y, int v) {
    if (!vertexMap.containsKey(x)) {
      vertexMap.put(x, new HashMap<>());
    }
    Map<Integer, Integer> map = vertexMap.get(x);

    if (!map.containsKey(y)) {
      map.put(y, v);
    } else {
      int pre = map.get(y);
      if ((pre & v) != 0) {
        return false;
      }
      map.put(y, pre | v);
    }
    return true;
  }

  public boolean isRectangleCover(int[][] rectangles) {
    int minX, minY;
    minX = minY = Integer.MAX_VALUE;
    int maxX, maxY;
    maxX = maxY = Integer.MIN_VALUE;
    long sizeSum = 0;
    Map<Integer, Map<Integer, Integer>> vertexMap = new HashMap<>();
    for (int[] rectangle : rectangles) {
      minX = Math.min(minX, rectangle[0]);
      minY = Math.min(minY, rectangle[1]);
      maxX = Math.max(maxX, rectangle[2]);
      maxY = Math.max(maxY, rectangle[3]);

      sizeSum += getSize(rectangle);

      if (!addVertex(vertexMap, rectangle[0], rectangle[1], 1)) {
        return false;
      }
      if (!addVertex(vertexMap, rectangle[2], rectangle[1], 2)) {
        return false;
      }
      if (!addVertex(vertexMap, rectangle[0], rectangle[3], 4)) {
        return false;
      }
      if (!addVertex(vertexMap, rectangle[2], rectangle[3], 8)) {
        return false;
      }
    }

    if (sizeSum != (maxX - minX) * (long)(maxY - minY)) {
      return false;
    }

    int count = 0;
    for (Map<Integer, Integer> map : vertexMap.values()) {
      for (Integer value : map.values()) {
        if (value == 1 || value == 2 || value == 4 || value == 8) {
          count++;
        }
      }
    }
    return count == 4;
  }
}
