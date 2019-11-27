package leetcode;

public class BattleshipsInABoard {

  private boolean isShip(char[][] board, int x, int y) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
      return false;
    }
    return board[x][y] == 'X';
  }

  public int countBattleships(char[][] board) {
    if (board == null || board.length == 0) {
      return 0;
    }

    int res = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (isShip(board, i, j) && !isShip(board, i - 1, j) && !isShip(board, i, j - 1)) {
          res++;
        }
      }
    }
    return res;
  }
}
