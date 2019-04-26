package top_interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    InterleavingString test = new InterleavingString();
    String s = "aabcc";
    String p = "dbbca";
    String s3 = "aadbbbaccc";
    int[] num1 = {1,2,3,4,5};
    int[] num2 = {3, 4, 7, 8, 14};
    char[] chars = {'A','A','A','B','B','B'};
    String[] strs = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    int n = 5;
    int m = 5;
    int[][] matrix = new int[][]{{-8},{-5},{-4},{-2},{0},{3},{4},{5},{6},{8},{9},{11},{13},{16},{18},{20},{23},{25},{26},{27},{29},{31},{32},{34},{37},{38},{41},{44},{46},{49},{51},{53},{56},{57},{58},{60},{63},{65},{68},{70},{73},{76},{77},{79},{82},{84},{87},{90},{92},{94}};
    char[][] board = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

    System.out.println(test.isInterleave(s, p, s3));
//      Tool.display(test.combine(n, m));
//        Tool.display(num1);
//        test.nextPermutation(num1);
//        Tool.display(num1);
  }
}
