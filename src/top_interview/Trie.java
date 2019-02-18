package top_interview;

import java.util.HashSet;
import java.util.Set;

class Trie {

    private Set<String> set;

    /** Initialize your data structure here. */
    public Trie() {
        set = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        set.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return set.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
