package top_interview;

public class SpiralMatrixII {

  public int[][] generateMatrix(int n) {
    int[][] board = new int[n][n];
    go(board, 0, n, 1);
    return board;
  }

  private void go(int[][] board, int index, int len, int start) {
    if (len == 0) {
      return;
    }
    if (len == 1) {
      board[index][index] = start;
      return;
    }

    for (int i = 0; i < len - 1; i++) {
      board[index][index + i] = start++;
    }
    for (int i = 0; i < len - 1; i++) {
      board[index + i][index + len - 1] = start++;
    }
    for (int i = 0; i < len - 1; i++) {
      board[index + len - 1][index + len - 1 - i] = start++;
    }
    for (int i = 0; i < len - 1; i++) {
      board[index + len - 1 - i][index] = start++;
    }
    go(board, index + 1, len - 2, start);
  }
}
