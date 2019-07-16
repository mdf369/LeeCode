package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  private WordNode root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new WordNode('a');
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    WordNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children.containsKey(c)) {
        node = node.children.get(c);
      } else {
        WordNode newNode = new WordNode(c);
        node.children.put(c, newNode);
        node = newNode;
      }
    }
    node.end = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return root.search(word, 0);
  }

  private class WordNode {
    public char value;
    public Map<Character, WordNode> children;
    public boolean end;

    public WordNode(char value) {
      this.value = value;
      this.children = new HashMap<>();
      end = false;
    }

    public boolean search(String s, int start) {
      if (start >= s.length()) {
        return end == true;
      }

      char c = s.charAt(start);
      if (c == '.') {
        for (WordNode node : children.values()) {
          if (node.search(s, start + 1)) {
            return true;
          }
        }
        return false;
      } else {
        if (children.containsKey(c)) {
          return children.get(c).search(s, start + 1);
        } else {
          return false;
        }
      }
    }
  }
}
