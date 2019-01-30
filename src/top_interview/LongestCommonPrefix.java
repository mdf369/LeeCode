package top_interview;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        if (strs.length == 0){
            return "";
        }

        while (true){
            boolean flag = false;
            if (index >= strs[0].length()){
                return strs[0];
            }
            char target = strs[0].charAt(index);
            for (String str : strs){
                if (index >= str.length() || str.charAt(index) != target){
                    return str.substring(0, index);
                }
            }
            index++;
        }
    }
}
