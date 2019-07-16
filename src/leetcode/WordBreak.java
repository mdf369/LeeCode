package leetcode;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Set<String>> lenMap = new HashMap<>();

        if (s == null || s.length() == 0) {
            return true;
        }

        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }

        for (String word : wordDict) {
            int len = word.length();
            if (lenMap.containsKey(len)) {
                lenMap.get(len).add(word);
            } else {
                Set<String> set = new HashSet<>();
                set.add(word);
                lenMap.put(len, set);
            }
        }
        int[] mem = new int[s.length()];

        return go(s, 0, mem, lenMap);
    }

    private boolean go(String s, int index, int[] mem, Map<Integer, Set<String>> lenMap) {
        if (index == s.length()) {
            return true;
        }
        if (mem[index] == 1) {
            return true;
        } else if (mem[index] == -1) {
            return false;
        }

        for (Map.Entry<Integer, Set<String>> entry : lenMap.entrySet()) {
            int len = entry.getKey();
            if (index + len > s.length()) {
                continue;
            }
            String target = s.substring(index, index + len);

            for (String word : entry.getValue()) {
                if (target.equals(word)) {
                    if (go(s, index + len, mem, lenMap)) {
                        mem[index] = 1;
                        return true;
                    }
                }
            }
        }
        mem[index] = -1;
        return false;
    }
}
