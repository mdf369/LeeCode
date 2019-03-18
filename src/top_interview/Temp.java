package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    CombinationSum test = new CombinationSum();
    String s = "(()(()";
    String p = "ab";
    int[] num1 = {2,3,5};
    int[] num2 = {3, 4, 7, 8, 14};
    char[] chars = {'A','A','A','B','B','B'};
    String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
        "+"};
    int n = 8;
    int m = 4;
    int[][] matrix = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
    char[][] board = new char[][]{
        {'0', '1', '1', '0', '1', '1'},
        {'O', 'O', '0', '0', '0', '0'},
        {'O', 'X', 'O', 'X', 'O', 'O'},
        {'O', 'X', 'O', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'O'},
        {'O', 'X', 'O', 'O', 'O', 'O'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

    System.out.println(test.combinationSum(num1, n));
//      Tool.display(test.reconstructQueue(matrix));
//        Tool.display(num1);
//        test.nextPermutation(num1);
//        Tool.display(num1);
  }
}
