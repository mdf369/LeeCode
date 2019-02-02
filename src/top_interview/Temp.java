package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) throws Exception {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String s = "catsanddog";
        String p = "dog";
        int[] num1 = {2};
        int[] num2 = {2};
        String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
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
        List<String> wordList = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println(test.evalRPN(strs));
//        Tool.display(board);
//        test.solve(board);
//        Tool.display(board);
    }
}
