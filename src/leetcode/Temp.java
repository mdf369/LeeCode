package leetcode;

import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    String s = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    String p = "AAACGGTA";
    String s3 = "abacab";
    int[] num1 = {3,1,3,3,10,7,10,3,6,9,10,3,7,6,7};
    int[] num2 = {3};
    char[] chars = {'a','a','b','b','c','c','c'};
    String[] strs = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    int n = 3;
    int m = 5;
    int z = 60;
    int[][] matrix = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    char[][] board = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");


    System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(strs));
//      Tool.display(new FindRightInterval().findRightInterval(matrix));
//        Tool.display(num1);
//    ListNode head = Tool.buildList(num1);
//    test.reorderList(head);
//    System.out.println(head);
  }
}
