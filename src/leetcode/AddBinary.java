package leetcode;

public class AddBinary {

  public String addBinary(String a, String b) {
    if (a.length() > b.length()) {
      String t = a;
      a = b;
      b = t;
    }

    int[] res = new int[2];
    int len = a.length();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      add(a.charAt(a.length() - 1 - i), b.charAt(b.length() - 1 - i), res);
      builder.append(res[0]);
    }

    addRest(builder, b.substring(0, b.length() - len), res[1]);
    return builder.reverse().toString();
  }

  private void addRest(StringBuilder builder, String s, int shift) {
    for (int i = s.length() - 1; i >= 0; i--) {
      if (shift > 0) {
        if (s.charAt(i) == '1') {
          builder.append(0);
        } else {
          builder.append(1);
          shift = 0;
        }
      } else {
        builder.append(s.charAt(i));
      }
    }
    if (shift == 1) {
      builder.append(1);
    }
  }

  private void add(char a, char b, int[] res) {
    int sum = a + b - '0' * 2 + res[1];
    res[0] = sum % 2;
    res[1] = sum >> 1;
  }
}
