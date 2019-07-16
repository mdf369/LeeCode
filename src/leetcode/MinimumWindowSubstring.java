package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int minStart = -1;
        int minEnd = s.length();
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()){
            set.add(c);
        }
        Map<Character, List<Integer>> locMap = new HashMap<>();
        set.forEach(c -> locMap.put(c, new ArrayList<>()));
        Map<Character, Integer> numMap = new HashMap<>();
        for (char c : t.toCharArray()){
            if (numMap.containsKey(c)){
                int num = numMap.get(c);
                numMap.put(c, num + 1);
            } else {
                numMap.put(c, 1);
            }
        }

        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);

            if (set.contains(c)){
                List<Integer> locList = locMap.get(c);
                if (locList.size() >= numMap.get(c)){
                    locList.remove(0);
                }
                locList.add(i);

                if (satisfied(locMap, t.length())){
                    int minLoc = s.length();
                    int maxLoc = 0;

                    for (Map.Entry<Character, List<Integer>> entry : locMap.entrySet()) {
                        for (int loc : entry.getValue()) {
                            minLoc = Math.min(minLoc, loc);
                            maxLoc = Math.max(maxLoc, loc);
                        }
                    }

                    if (minEnd - minStart > maxLoc - minLoc) {
                        minStart = minLoc;
                        minEnd = maxLoc;
                    }
                }
            }
        }

        if (minStart >= 0){
            return s.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }

    private boolean satisfied(Map<Character, List<Integer>> map, int sum){
        int count = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            count += entry.getValue().size();
        }

        return count == sum;
    }
}
