package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int startIndex = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0;i < s.length();i++){
            Character c = s.charAt(i);

            if(set.contains(c)){
                int index = s.indexOf(c, startIndex);
                startIndex = index+1;
                max = Math.max(max, set.size());
                set.clear();

                for(int j = startIndex; j <= i; j++){
                    set.add(s.charAt(j));
                }
            } else {
                set.add(c);
            }
        }

        max = Math.max(max, set.size());
        return max;
    }
}
