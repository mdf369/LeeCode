package leetcode;

import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    ExpressionAddOperators test = new ExpressionAddOperators();
    String s = "123456789";
    String p = "aa";
    String s3 = "AAAAAAAAAAA";
    int[] num1 = {3,0,6,1,5};
    int[] num2 = {3, 4, 7, 8, 14};
    char[] chars = {'A','A','A','B','B','B'};
    String[] strs = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    int n = 45;
    int m = 1;
    int[][] matrix = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
    char[][] board = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

    System.out.println(test.addOperators(s, n));
//      Tool.display(test.combine(n, m));
//        Tool.display(num1);
//    ListNode head = Tool.buildList(num1);
//    test.reorderList(head);
//    System.out.println(head);
  }
}
