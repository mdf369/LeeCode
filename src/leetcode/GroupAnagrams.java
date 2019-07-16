package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, int[]> map = new HashMap<>();

        for (String str : strs){
            boolean flag = false;
            for (List<String> list : res){
                int[] array = map.get(list.get(0));
                if (isAnagram(array, str)){
                    flag = true;
                    list.add(str);
                    break;
                }
            }

            if (!flag){
                int[] array = buildArray(str);
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str, array);
                res.add(list);
            }
        }

        return res;
    }

    private boolean isAnagram(int[] array, String str){
        int[] array2 = buildArray(str);

        for (int i = 0;i < array.length;i++){
            if (array[i] != array2[i]){
                return false;
            }
        }
        return true;
    }

    private int[] buildArray(String str){
        char[] chars = str.toCharArray();
        int[] array = new int[26];

        for (char c : chars){
            array[c - 'a']++;
        }
        return array;
    }
}
