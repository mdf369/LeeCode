package leetcode;

public class RemoveKDigits {

  private String removeLeadingZero(String num) {
    int index = 0;
    while (index < num.length() && num.charAt(index) == '0') {
      index++;
    }
    if (index == num.length()) {
      return "0";
    }
    return num.substring(index);
  }

  public String removeKdigits(String num, int k) {
    if (k == 0) {
      return num;
    }
    if (k == num.length()) {
      return "0";
    }

    k = num.length() - k;
    int start = 0;
    char curC = '0';
    int count = 0;
    StringBuilder builder = new StringBuilder();
    while (count < k) {
      int index = num.indexOf(curC, start);
      if (index == -1 || num.length() - index < k - count) {
        curC++;
        continue;
      }

      start = index + 1;
      builder.append(curC);
      count++;
      curC = '0';
    }
    return removeLeadingZero(builder.toString());
  }
}
