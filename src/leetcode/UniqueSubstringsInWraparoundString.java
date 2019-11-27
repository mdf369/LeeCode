package leetcode;

public class UniqueSubstringsInWraparoundString {

  private boolean isPre(char c, char pre) {
    if (pre == 'z') {
      return c == 'a';
    }
    return pre + 1 == c;
  }

  private int[] countLen(String s) {
    int index = 0;
    int[] lens = new int[26];
    int len = 0;
    char pre = '\0';
    while (index < s.length()) {
      char c = s.charAt(index);
      if (pre != '\0' && !isPre(c, pre)) {
        pre = '\0';
        len = 0;
      } else {
        pre = c;
        len++;
        lens[c - 'a'] = Math.max(lens[c - 'a'], len);
        index++;
      }
    }
    if (len > 0) {
      lens[s.charAt(index - 1) - 'a'] = Math.max(lens[s.charAt(index - 1) - 'a'], len);
    }
    return lens;
  }

  private int getCount(int n) {
    return (n + 1) * n / 2;
  }

  public int findSubstringInWraproundString(String p) {
    int res = 0;
    int[] lens = countLen(p);
    for (Integer len : lens) {
      res += len;
    }
    return res;
  }
}
