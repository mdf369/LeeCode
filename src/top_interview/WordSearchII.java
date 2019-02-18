package top_interview;

import java.util.*;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (words == null) {
            return Collections.emptyList();
        }

        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        List<String> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }

    private boolean exist(char[][] board, String word) {
        if (word.length() == 0){
            return true;
        }
        if (board.length == 0){
            return false;
        }

        int len = word.length();
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[i].length;j++){
                if(search(board, word, 0, j, i, len, used)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int x, int y, int len, boolean[][] used){
        if (x < 0 || x >= board[0].length){
            return false;
        }
        if (y < 0 || y >= board.length){
            return false;
        }
        if (index >= len){
            return false;
        }

        if (used[y][x]){
            return false;
        }

        if (board[y][x] != word.charAt(index)){
            return false;
        } else {
            if (index == len - 1){
                return true;
            }
        }

        used[y][x] = true;
        if (search(board, word, index + 1, x - 1, y, len, used)){
            return true;
        }

        if (search(board, word, index + 1, x + 1, y, len, used)){
            return true;
        }

        if (search(board, word, index + 1, x, y - 1, len, used)){
            return true;
        }

        if (search(board, word, index + 1, x, y + 1, len, used)){
            return true;
        }

        used[y][x] = false;
        return false;
    }
}
