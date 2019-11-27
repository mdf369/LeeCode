package leetcode;

public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    if (s.length() == 0) {
      return 0;
    }

    int start = 0;
    int maxCount = 0;
    int[] counts = new int[26];
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'A';

      counts[index]++;
      maxCount = Math.max(maxCount, counts[index]);

      while (i - start + 1 - maxCount > k) {
        counts[s.charAt(start) - 'A']--;
        start++;
      }

      res = Math.max(res, i - start + 1);
    }
    return res;
  }
}
