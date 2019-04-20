package top_interview;

public class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];
    mem[mem.length - 1][mem[0].length - 1] = 1;
    for (int i = 0; i < mem.length; i++) {
      for (int j = 0; j < mem[i].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          mem[i][j] = 1;
        } else {
          mem[i][j] = -1;
        }
      }
    }
    return go(obstacleGrid, mem, 0, 0);
  }

  private int go(int[][] graph, int[][] mem, int x, int y) {
    if (x >= graph.length || y >= graph[0].length || graph[x][y] == 1) {
      return 0;
    }
    if (x == graph.length - 1 && y == graph[0].length - 1) {
      return 1;
    }

    if (mem[x][y] != -1) {
      return mem[x][y];
    }
    int count = go(graph, mem, x + 1, y) + go(graph, mem, x, y + 1);
    mem[x][y] = count;
    return count;
  }
}
