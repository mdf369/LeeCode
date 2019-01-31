package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) throws Exception {
        PalindromePartitioning test = new PalindromePartitioning();
        String s = "aab";
        String p = "dog";
        int[] num1 = {1,2,3,4,5,4,3,2,1};
        int[] num2 = {1,2,3,4};
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        int n = 3;
        int m = 3;
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        char[][] board = new char[][]{
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};
        List<String> wordList = Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot");

        System.out.println(test.partition(s));
//        Tool.display(board);
//        test.solve(board);
//        Tool.display(board);
    }
}
