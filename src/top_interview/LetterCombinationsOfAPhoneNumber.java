package top_interview;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Integer, List<Character>> map;
    static {
        map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();

        if (digits.length() == 0){
            return res;
        }

        addC(digits, 0, "", '*');
        return res;
    }

    private void addC(String str, int index, String s, char c){
        if (index == str.length()){
            res.add(s.substring(1) + c);
            return;
        }

        List<Character> candidate = map.get(str.charAt(index) - '0');
        for (Character nextC : candidate){
            addC(str, index + 1, s + c, nextC);
        }
    }
}
