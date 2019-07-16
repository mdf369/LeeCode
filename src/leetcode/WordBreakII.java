package leetcode;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Map<Integer, Set<String>> lenMap = new HashMap<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        if (wordDict == null || wordDict.size() == 0) {
            return res;
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
        List<Set<String>> wordMem = new ArrayList<>(s.length());
        for (int i = 0;i < s.length();i++) {
            wordMem.add(new HashSet<>());
        }
        String[] words = new String[s.length()];

        go(s, 0, mem, wordMem, lenMap);
        buildRes(wordMem, res);
        return res;
    }

    private void buildRes(List<Set<String>> wordMem, List<String> res) {
        String[] words = new String[wordMem.size()];
        search(wordMem, 0, words, 0, res);
    }

    private void search(List<Set<String>> wordMem, int index, String[] words, int depth, List<String> res) {
        if (index == wordMem.size()) {
            res.add(buildSubRes(words, depth));
            return;
        } else if (index > wordMem.size()) {
            return;
        }

        for (String word : wordMem.get(index)) {
            words[depth] = word;
            search(wordMem, index + word.length(), words, depth + 1, res);
        }
    }

    private String buildSubRes(String[] words, int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append(words[i]).append(" ");
        }
        String subRes = builder.toString();
        subRes = subRes.substring(0, subRes.length() - 1);
        return subRes;
    }

    private boolean go(String s, int index, int[] mem, List<Set<String>> wordMem, Map<Integer, Set<String>> lenMap) {
        if (index == s.length()) {
            return true;
        }

        if (mem[index] == 1) {
            return true;
        } else if (mem[index] == -1) {
            return false;
        }

        int count = 0;
        for (Map.Entry<Integer, Set<String>> entry : lenMap.entrySet()) {
            int len = entry.getKey();
            if (index + len > s.length()) {
                continue;
            }
            String target = s.substring(index, index + len);

            for (String word : entry.getValue()) {
                if (target.equals(word)) {
                    if (go(s, index + len, mem, wordMem, lenMap)) {
                        mem[index] = 1;
                        wordMem.get(index).add(word);
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            mem[index] = -1;
        }
        return count > 0;
    }
}
