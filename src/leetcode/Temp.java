package leetcode;

import java.util.Arrays;
import java.util.List;

public class Temp {

  public static void main(String[] args) throws Exception {
    VerifyPreorderSerializationOfABinaryTree test = new VerifyPreorderSerializationOfABinaryTree();
    String s = "1,#";
    String p = "aa";
    String s3 = "AAAAAAAAAAA";
    int[] num1 = {1,3};
    int[] num2 = {1,7,5};
    char[] chars = {'A','A','A','B','B','B'};
    String[] strs = new String[]{"cdbbfebebafbefc","ecbeaeddcce","aefeeddafccaedafddd","cbe","ececca","adcfdbdffcebfedadcb","edbfadcecbebfee","eabcb","bdfedaedbaeacf","faabafbbbefdea","deccfdffacbebdefbfa","ffdf","fdbeabbec","cbcfeedaf","ecdbfdebbebffbbbb","ebee","cfcdcbcfdacbdaaebfef","dafabedfa","babbdfcc","eadeafdbcdbbaefbbbbdc","faabad","eeeaecdbbacbedbaeabd","acfa","eaaafeb","acef","dccaccfffedaabefccead","bacdbfe","fdfdafaa","bacecdff","cfadccadfdabbdcdaec","acbdfffdbcdfffbdbec","afbcfefc","facaacffccecfff","af","aedcddabdddfdeafabfd","fafbfeacffbbbceebaedc","aabbbabddcadadda","eccca","fcafbdfb","ffdadaeaebedec","ccfc","efaed","eebbb","dcafccfbbdfbddcfbefb","aaeeb","fcdd","ccccb","ddebebfdcdbaaf","beeeb","edbfdabdcfb","cacfbf","bceacbdababbfca","ffb","fcba","bdfedbaafebbffcefece","bf","dbfbeabcecffdbcc","dccebefccbecf","aaebfacdaaabfbcfacd","cb","edbbbfcdbefeabcfd","daabdcbadccfeffafa","cfafbcdfbdabfadddddff","cbfd","bcaa","dffbfebffedc","ebcbfbaeadbbdfcaa","dcedebbcdfffabbac","dbedacddcec","badedda","beeeaaffcdadbdecaddc","dcdbcdbffeddcfea","dedbdecbca","cbecacdcfcdcfbfeebdda","bebbacebbfacfbbbed","dc","cdddaedbfeaeebdbef","accbbd","bbafead","dcfba","efac","ffce","cfa","bac","bdfdfecccfeadeafedee","eedddbefdaefbcbf","acedbeadaedfcdffebea","cc","cffbeebdedfdbf","fdeacddefadbdecbe","ccccedafdbedaeeb","cfafddadadcfdbdfb","aadbbedecd","cadeffaaffdcaeeefdfbf","adcaaefbffdfaadedbbb","cbeebfeeddcfd","abfaaecdffbdfafe","fccbbae","cefdee","cfdbfbabacafecc"};
    int n = 6;
    int m = 3864;
    int[][] matrix = new int[][]{{0,3},{1,3},{2,3},{4,3},{5,4}};
    char[][] board = new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'},
        {'1', '0', '0', '1', '0'}};
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

    System.out.println(test.isValidSerialization(s));
//      Tool.display(test.maxNumber(num1, num2, n));
//        Tool.display(num1);
//    ListNode head = Tool.buildList(num1);
//    test.reorderList(head);
//    System.out.println(head);
  }
}
