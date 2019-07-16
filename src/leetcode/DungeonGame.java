package leetcode;

public class DungeonGame {

  private int min = Integer.MAX_VALUE;

  public int calculateMinimumHP(int[][] dungeon) {
    int height = dungeon.length;
    int width = dungeon[0].length;

    int[][][] mem = new int[height][width][2];
    for (int i = 0; i < mem.length; i++) {
      for (int j = 0; j < mem[i].length; j++) {
        go(dungeon, 0, 0, 0, 0);
      }
    }

    return min + 1;
  }

  private void go(int[][] dungeon, int x, int y, int hp, int maxHP) {
    if (x >= dungeon.length || y >= dungeon[0].length) {
      return;
    }

    hp += dungeon[x][y];
    maxHP = Math.max(maxHP, -hp);
    if (maxHP >= min) {
      return;
    }
    if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
      min = Math.min(min, maxHP);
    }

    go(dungeon, x + 1, y, hp, maxHP);
    go(dungeon, x, y + 1, hp, maxHP);
  }
}
