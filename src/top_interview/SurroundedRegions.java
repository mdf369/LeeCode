package top_interview;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }

        int h = board.length;
        if (h <= 2) {
            return;
        }
        int w = board[0].length;
        if (w <= 2) {
            return;
        }

        int[][] mem = new int[h][w];
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                if (board[i][j] == 'O' && mem[i][j] == 0) {
                    if (isFlipable(board, mem, i, j)) {
                        flip(board, i, j);
                    }
                }
            }
        }
    }

    private boolean isFlipable(char[][] board, int[][] mem, int i, int j) {
        if (mem[i][j] != 0) {
            return true;
        }

        if (board[i][j] != 'O') {
            return true;
        }

        mem[i][j] = 1;

        if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
            return false;
        }

        int count = 0;
        if (!isFlipable(board, mem, i - 1, j)) {
            count++;
        }
        if (!isFlipable(board, mem, i + 1, j)) {
            count++;
        }
        if (!isFlipable(board, mem, i, j - 1)) {
            count++;
        }
        if (!isFlipable(board, mem, i, j + 1)) {
            count++;
        }
        return count == 0;
    }

    private void flip(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'X';
        flip(board, i - 1, j);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
        flip(board, i, j + 1);
    }
}
