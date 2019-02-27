package top_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        if (wordList == null || wordList.size() < 1) {
            return 0;
        }

        int endIndex = 0;
        while (endIndex < wordList.size()) {
            if (endWord.equals(wordList.get(endIndex))) {
                break;
            }
            endIndex++;
        }
        if (endIndex == wordList.size()) {
            return 0;
        }

        Set<String> candidate = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (isValid(beginWord, wordList.get(i))) {
                candidate.add(wordList.get(i));
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        int[] used = new int[wordList.size()];
        queue.add(new Pair<>(endWord, 1));
        used[endIndex] = 1;
        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();

            if (candidate.contains(word)) {
                return pair.getValue() + 1;
            }

            for (int i = 0; i < wordList.size(); i++) {
                String newWord = wordList.get(i);
                if (used[i] == 1) {
                    continue;
                }

                if (isValid(word, newWord)) {
                    queue.add(new Pair<>(newWord, pair.getValue() + 1));
                    used[i] = 1;
                }
            }
        }
        return 0;
    }

    private boolean isValid(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
