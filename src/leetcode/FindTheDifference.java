package leetcode;

public class FindTheDifference {

  public char findTheDifference(String s, String t) {
    int[] mem = new int[26];

    for (int i = 0; i < s.length(); i++) {
      mem[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < t.length(); i++) {
      int index = t.charAt(i) - 'a';
      mem[index]--;
      if (mem[index] < 0) {
        return t.charAt(i);
      }
    }
    return 0;
  }
}
