package top_interview;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board == null) {
            return;
        }

        int h = board.length;
        if (h == 0) {
            return;
        }
        int w = board[0].length;
        if (w == 0) {
            return;
        }

        int[][] newBoard = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int count = getLiveNeighbourNum(board, i, j, h, w);
                if (board[i][j] == 0) {
                    if (count == 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                } else {
                    if (count >= 2 && count <= 3) {
                        newBoard[i][j] = 1;
                    } else {
                        newBoard[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private int getLiveNeighbourNum(int[][] board, int x, int y, int h, int w) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (checkIsValid(x + i, h) && checkIsValid(y + j, w)) {
                    if (board[x + i][y + j] == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean checkIsValid(int n, int limit) {
        return n >= 0 && n < limit;
    }
}
