package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
    String s = "hit";
    String p = "cog";
    int[] num1 = {8,6,4,3,3,2,3,5,8,3,8,2,6};
    int[] num2 = {3, 4, 7, 8, 14};
    String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5",
        "+"};
    int n = 16;
    int m = -2147483648;
    int[][] matrix = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    char[][] board = new char[][]{
        {'0', '1', '1', '0', '1', '1'},
        {'O', 'O', '0', '0', '0', '0'},
        {'O', 'X', 'O', 'X', 'O', 'O'},
        {'O', 'X', 'O', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'O'},
        {'O', 'X', 'O', 'O', 'O', 'O'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");

    System.out.println(test.maxProfit(num1));
//      Tool.display(test.intersect(num1, num2));
//        Tool.display(num1);
//        test.wiggleSort(num1);
//        Tool.display(num1);
  }
}
