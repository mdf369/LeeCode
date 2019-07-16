package leetcode;

public class MultiplyStrings {

  public String multiply(String num1, String num2) {
    String res = "0";
    int depth = 0;
    for (int i = num2.length() - 1; i >= 0; i--) {
      res = add(res, mult(num1, num2.charAt(i) - '0', depth));
      depth++;
    }
    int index = 0;
    while (index < res.length() - 1 && res.charAt(index) == '0') {
      index++;
    }
    return res.substring(index);
  }

  private String mult(String s, int factor, int depth) {
    int shift = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      int subres = mult(s.charAt(i), factor) + shift;
      shift = subres / 10;
      subres = subres % 10;
      builder.append(subres);
    }
    if (shift > 0) {
      builder.append(shift);
    }
    builder.reverse();
    for (int i = 0; i < depth; i++) {
      builder.append(0);
    }
    return builder.toString();
  }

  private int mult(char c, int factor) {
    return (c - '0') * factor;
  }

  private String add(String a, String b) {
    if (a.length() < b.length()) {
      String t = a;
      a = b;
      b = t;
    }

    String aRest = a.substring(0, a.length() - b.length());
    a = a.substring(a.length() - b.length());
    StringBuilder res = new StringBuilder();
    int shift = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
      int sum = add(a.charAt(i), b.charAt(i)) + shift;
      if (sum >= 10) {
        shift = 1;
        sum -= 10;
      } else {
        shift = 0;
      }
      res.append(sum);
    }
    if (shift > 0) {
      int i = aRest.length() - 1;
      char[] chars = aRest.toCharArray();
      while (i >= 0) {
        int sum = chars[i] + shift - '0';
        if (sum >= 10) {
          shift = 1;
          sum -= 10;
          chars[i] = (char) (sum + '0');
          i--;
        } else {
          shift = 0;
          chars[i] = (char) (sum + '0');
          break;
        }
      }
      aRest = String.valueOf(chars);
    }
    if (shift > 0) {
      aRest = shift + aRest;
    }

    return aRest + res.reverse().toString();
  }

  private int add(char a, char b) {
    return a + b - '0' * 2;
  }
}
