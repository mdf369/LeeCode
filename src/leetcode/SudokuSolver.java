package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

  public void solveSudoku(char[][] board) {
    List<int[]> emptyCellLocList = getEmptyCellLocList(board);

    put(board, emptyCellLocList, 0);
  }

  private boolean put(char[][] board, List<int[]> locList, int index) {
    if (index >= locList.size()) {
      return true;
    }
    int[] loc = locList.get(index);
    for (int i = 1; i <= 9; i++) {
      if (isValid(board, (char) ('0' + i), loc[0], loc[1])) {
        board[loc[0]][loc[1]] = (char) ('0' + i);
        if (put(board, locList, index + 1)) {
          return true;
        }
        board[loc[0]][loc[1]] = '.';
      }
    }
    return false;
  }

  private List<int[]> getEmptyCellLocList(char[][] board) {
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          list.add(new int[]{i, j});
        }
      }
    }
    return list;
  }

  private boolean isValid(char[][] board, char num, int x, int y) {
    for (int i = 0; i < board.length; i++) {
      if (board[x][i] == num) {
        return false;
      }

      if (board[i][y] == num) {
        return false;
      }
    }

    int xStart = x / 3 * 3;
    int yStart = y / 3 * 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[xStart + i][yStart + j] == num) {
          return false;
        }
      }
    }

    return true;
  }
}
