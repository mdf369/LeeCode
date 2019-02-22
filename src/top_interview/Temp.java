package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) throws Exception {
      IntersectionOfTwoArraysII test = new IntersectionOfTwoArraysII();
        String s = "3/2 + 10";
        String p = "dog";
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int n = 9832;
        int m = -2147483648;
        int[][] matrix = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        char[][] board = new char[][]{
                {'0','1','1','0','1','1'},
                {'O','O','0','0','0','0'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};
        List<String> wordList = Arrays.asList("cat", "cats", "and", "sand", "dog");

//        System.out.println(test.increasingTriplet(num1));
      Tool.display(test.intersect(num1, num2));
//        Tool.display(num1);
//        test.wiggleSort(num1);
//        Tool.display(num1);
    }
}
