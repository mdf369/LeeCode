package leetcode;

public class ReconstructOriginalDigitsFromEnglish {

  private int count(String s, char c) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  public String originalDigits(String s) {
    char[] chars = new char[]{'z', 'w', 'u', 'x', 'g'};
    int[] cCounts = new int[10];
    for (int i = 0; i < chars.length; i++) {
      cCounts[i * 2] = count(s, chars[i]);
    }

    cCounts[1] = count(s, 'o') - cCounts[0] - cCounts[2] - cCounts[4];
    cCounts[3] = count(s, 'h') - cCounts[8];
    cCounts[5] = count(s, 'f') - cCounts[4];
    cCounts[7] = count(s, 's') - cCounts[6];
    cCounts[9] = count(s, 'i') - cCounts[5] - cCounts[6] - cCounts[8];

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < cCounts.length; i++) {
      for (int j = 0; j < cCounts[i]; j++) {
        builder.append((char)('0' + i));
      }
    }
    return builder.toString();
  }
}
