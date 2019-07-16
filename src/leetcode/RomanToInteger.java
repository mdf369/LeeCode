package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> map = new HashMap<>();
    private static List<Character> cList = new ArrayList<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        cList.add('M');
        cList.add('D');
        cList.add('C');
        cList.add('L');
        cList.add('X');
        cList.add('V');
        cList.add('I');
    }

    public int romanToInt(String s) {
        return romanToInt(s, 0);
    }

    private int romanToInt(String s, int degree){
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return map.get(s.charAt(0));
        }

        char c = cList.get(degree);
        int index = s.indexOf(c);
        int value = map.get(c);

        if (index == -1){
            return romanToInt(s, degree + 1);
        } else {
            int sub = romanToInt(s.substring(0, index), degree + 1);
            int sum = romanToInt(s.substring(index + 1), degree);
            return value + sum - sub;
        }
    }
}
