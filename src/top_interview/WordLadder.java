package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (isValid(beginWord, endWord)) {
            return 2;
        }

        int[] mem = new int[wordList.size()];

        int index = wordList.indexOf(endWord);
        if (index == -1) {
            return 0;
        }
        mem[index] = 1;

        int count = 1;
        while (count > 0) {
            count = 0;
            for (int i = 0; i < wordList.size(); i++) {
                if (mem[i]  == 0) {
                    index = getValidMinIndex(wordList.get(i), wordList, mem);
                    if (index >= 0) {
                        mem[i] = mem[index] + 1;
                        count++;
                        if (isValid(wordList.get(i), beginWord)) {
                            return mem[i] + 1;
                        }
                    }
                }
            }
        }

        int min = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (isValid(beginWord, wordList.get(i)) && mem[i] > 0) {
                if (min >= 0) {
                    min = Math.min(min, mem[i]);
                } else {
                    min = mem[i];
                }
            }
        }
        return min + 1;
    }

    private int getValidMinIndex(String target, List<String> wordList, int[] mem) {
        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (isValid(target, wordList.get(i)) && mem[i] > 0) {
                candidate.add(i);
            }
        }
        if (candidate.isEmpty()) {
            return -1;
        } else {
            int minIndex = 0;
            for (int i = 0; i < candidate.size(); i++) {
                if (mem[candidate.get(minIndex)] > mem[candidate.get(i)]) {
                    minIndex = i;
                }
            }
            return candidate.get(minIndex);
        }
    }

    private boolean isValid(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
