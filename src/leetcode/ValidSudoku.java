package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    private final int LEN = 9;
    private final char EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0;i < LEN;i++){
            if (!isValidMatric(board, i, 0, 1, LEN)){
                return false;
            }
            if (!isValidMatric(board, 0, i, LEN, 1)){
                return false;
            }
        }

        for (int i = 0;i < LEN / 3;i++){
            for (int j = 0;j < LEN / 3;j++){
                if (!isValidMatric(board, i * 3, j * 3, 3, 3)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidMatric(char[][] board, int x, int y, int w, int h){
        Set<Character> set = new HashSet<>();

        for (int i = y; i < y + h;i++){
            for (int j = x;j < x + w;j++){
                char c = board[i][j];
                if (c == EMPTY){
                    continue;
                }
                if (set.contains(c)){
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }
}
