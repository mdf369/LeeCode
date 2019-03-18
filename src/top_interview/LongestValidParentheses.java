package top_interview;

public class LongestValidParentheses {

  public int longestValidParentheses(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int count = 0;
    int max = 0;
    int start = 0;
    int lastMatch = -1;
    while (start < s.length()) {
      int index = start;
      count = 0;
      lastMatch = -1;
      while (index < s.length() && count >= 0) {
        if (s.charAt(index) == '(') {
          count++;
        } else {
          count--;
          if (count == 0) {
            max = Math.max(max, index - start + 1);
          } else if (count > 0) {
            if (lastMatch < start) {
              lastMatch = index;
            }
            lastMatch = index;

            int index2 = lastMatch - 1;
            int count2 = 1;
            while (index2 >= start) {
              if (s.charAt(index2) == '(') {
                count2--;
              } else {
                count2++;
              }

              if (count2 < 0) {
                max = Math.max(max, index - index2);
                lastMatch = index2 + 1;
                break;
              }
              index2--;
            }
          } else {

          }
        }

        index++;
      }

      start = index;
    }

    return max;
  }
}
