package leetcode;

public class StrongPasswordChecker {

  private final int MIN_LEN = 6;
  private final int MAX_LEN = 20;
  
  private boolean isBetween(char c, char low, char up) {
    return c >= low && c <= up;  
  }
  
  public int strongPasswordChecker(String s) {
    boolean[] isExist = new boolean[3];
    char[][] bounds = new char[][]{{'a', 'z'}, {'A', 'Z'}, {'0', '9'}};
    int count = 0;
    for (int i = 0; i < s.length() && count < bounds.length; i++) {
      for (int j = 0; j < bounds.length; j++) {
        if (!isExist[j] && isBetween(s.charAt(i), bounds[j][0], bounds[j][1])) {
          isExist[j] = true;
          count++;
        }
      }
    }

    int res = 0;
    int len = s.length();
    int toInsertNum = bounds.length - count;
    char pre = '\0';
    for (int i = 0; i < s.length(); i++) {
      if (pre == s.charAt(i)) {
        count++;
      } else {
        pre = s.charAt(i);
        count = 1;
      }

      if (count >= 3) {
        if (len > MAX_LEN) {
          len--;
          count--;
        } else {
          if (len < MIN_LEN) {
            len++;
          }
          toInsertNum--;

          count = 0;
          pre = '\0';
        }

        res++;
      }
    }

    if (len > MAX_LEN) {
      res += len - MAX_LEN;
    } else if (len < MIN_LEN) {
      res += MIN_LEN - len;
      toInsertNum -= MIN_LEN - len;
    }

    if (toInsertNum > 0) {
      res += toInsertNum;
    }

    return res;
  }
}
