package leetcode;

public class RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] mem = new int[26];

    for (int i = 0; i < magazine.length(); i++) {
      mem[magazine.charAt(i) - 'a']++;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      int index = ransomNote.charAt(i) - 'a';
      if (mem[index] == 0) {
        return false;
      }
      mem[index]--;
    }
    return true;
  }
}
