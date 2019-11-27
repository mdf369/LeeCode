package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrappingRainWaterII {

  private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private void enQueue(Queue<int[]> queue, int x, int y, int[][] visitedMap) {
    visitedMap[x][y] = 1;
    queue.add(new int[]{x, y});
  }

  private int getHeight(int[][] heightMap, int[] loc) {
    return heightMap[loc[0]][loc[1]];
  }

  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0) {
      return 0;
    }

    int length = heightMap.length;
    int width = heightMap[0].length;
    int[][] visitedMap = new int[length][width];
    Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return getHeight(heightMap, o1) - getHeight(heightMap, o2);
      }
    });

    for (int i = 0; i < length; i++) {
      enQueue(queue, i, 0, visitedMap);
      enQueue(queue, i, width - 1, visitedMap);
    }
    for (int i = 0; i < width; i++) {
      enQueue(queue, 0, i, visitedMap);
      enQueue(queue, length - 1, i, visitedMap);
    }

    int res = 0;
    int h = 0;
    while (!queue.isEmpty()) {
      int[] loc = queue.poll();
      if (getHeight(heightMap, loc) > h) {
        h = getHeight(heightMap, loc);
      }

      for (int[] dir : direction) {
        int x = loc[0] + dir[0];
        int y = loc[1] + dir[1];
        if (x >= 0 && x < length && y >= 0 && y < width) {
          if (visitedMap[x][y] == 0) {
            enQueue(queue, x, y, visitedMap);
            if (h > heightMap[x][y]) {
              res += h - heightMap[x][y];
            }
          }
        }
      }
    }
    return res;
  }
}
