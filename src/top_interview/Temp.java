package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temp {

    public static void main(String[] args) throws Exception {
        BasicCalculatorII test = new BasicCalculatorII();
        String s = "3/2 + 10";
        String p = "dog";
        int[] num1 = {3,30,34,5,9};
        int[] num2 = {2};
        String[] strs = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int n = 2;
        int m = -2147483648;
        int[][] matrix = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        char[][] board = new char[][]{
                {'0','1','1','0','1','1'},
                {'O','O','0','0','0','0'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}};
        List<String> wordList = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println(test.calculate(s));
//        Tool.display(num1);
//        test.rotate(num1, n);
//        Tool.display(num1);
    }
}
