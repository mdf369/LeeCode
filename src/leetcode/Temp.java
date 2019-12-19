package leetcode;

import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    String s = "abc";
    String p = "WRBRW";
    String s3 = "abacab";
    int[] num1 = {1,2,5};
    int[] num2 = {3};
    char[] chars = {'a','a','b','b','c','c','c'};
    String[] strs = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
    int n = 2;
    int m = 5;
    int z = 60;
    int[][] matrix = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    char[][] board = new char[][] {
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");


    System.out.println(new TeemoAttacking().findPoisonedDuration(num1, n));
//      Tool.display(new SlidingWindowMedian().medianSlidingWindow(num1, n));
//        Tool.display(num1);
//    ListNode head = Tool.buildList(num1);
//    test.reorderList(head);
//    System.out.println(head);
  }
}
