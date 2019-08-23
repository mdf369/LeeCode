package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {

  private Set<Character> vowelSet = new HashSet<>();
  {
    vowelSet.add('A');
    vowelSet.add('a');
    vowelSet.add('E');
    vowelSet.add('e');
    vowelSet.add('O');
    vowelSet.add('o');
    vowelSet.add('U');
    vowelSet.add('u');
    vowelSet.add('I');
    vowelSet.add('i');
  }

  public String reverseVowels(String s) {
    StringBuilder builder = new StringBuilder();
    boolean[] flags = new boolean[s.length()];

    for (int i = 0; i < s.length(); i++) {
      flags[i] = vowelSet.contains(s.charAt(i));
      if (flags[i]) {
        builder.append(s.charAt(i));
      }
    }
    builder.reverse();

    StringBuilder res = new StringBuilder();
    int index = 0;
    for (int i = 0; i < flags.length; i++) {
      if (flags[i]) {
        res.append(builder.charAt(index++));
      } else {
        res.append(s.charAt(i));
      }
    }
    return res.toString();
  }
}
