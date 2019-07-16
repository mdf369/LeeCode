package leetcode;

import javafx.util.Pair;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        if (width == 0) {
            return 0;
        }

        int[][] mem = new int[height][width];

        int count = 0;
        Pair<Integer, Integer> loc;
        while ((loc = getUndiscoveredIslandLoc(grid, mem, height, width)) != null) {
            count++;

            discoverIsland(grid, mem, height, width, loc.getKey(), loc.getValue());
        }
        return count;
    }

    private void discoverIsland(char[][] grid, int[][] mem, int height, int width, int x, int y) {
        if (x < 0 || x >= height || y < 0 || y >= width || mem[x][y] == 1) {
            return;
        }
        mem[x][y] = 1;
        if (grid[x][y] == '1') {
            discoverIsland(grid, mem, height, width, x - 1, y);
            discoverIsland(grid, mem, height, width, x + 1, y);
            discoverIsland(grid, mem, height, width, x, y - 1);
            discoverIsland(grid, mem, height, width, x, y + 1);
        }
    }

    private Pair<Integer, Integer> getUndiscoveredIslandLoc(char[][] grid, int[][] mem, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mem[i][j] == 0 && grid[i][j] == '1') {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }
}
