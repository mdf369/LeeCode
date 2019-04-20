package top_interview;

public class ValidNumber {

  public boolean isNumber(String s) {
    s = s.trim();
    int index = s.indexOf('e');
    if (index == -1) {
      return isComplexNumber(s, 0, s.length(), false);
    } else {
      return isComplexNumber(s, 0, index, false) && isComplexNumber(s, index + 1, s.length(), true);
    }
  }

  private boolean isComplexNumber(String s, int start, int end, boolean strict) {
    if (start >= end) {
      return false;
    }
    if (s.charAt(start) == '-' || s.charAt(start) == '+') {
      start++;
    }
    int index = s.indexOf('.', start);
    if (index == -1) {
      return isSimpleNumber(s, start, end);
    } else if (!strict && index == start) {
      return isSimpleNumber(s, index + 1, end);
    } else if (!strict && index == end - 1) {
      return isSimpleNumber(s, start, index);
    } else {
      return isSimpleNumber(s, start, index) && isSimpleNumber(s, index + 1, end);
    }
  }

  private boolean isSimpleNumber(String s, int start, int end) {
    if (start >= end) {
      return false;
    }
    for (int i = start; i < end; i++) {
      if (!isNumber(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }
}
