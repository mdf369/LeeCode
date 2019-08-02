package leetcode;

public class AdditiveNumber {

  public boolean isAdditiveNumber(String num) {
    if (num == null || num.length() < 3) {
      return false;
    }

    int alimit = num.charAt(0) == '0' ? 1 : num.length() - 2;
    for (int i = 1; i <= alimit; i++) {
      int blimit = num.charAt(i) == '0' ? i + 1 : num.length() - 1;
      for (int j = i + 1; j <= blimit; j++) {
        if (isAdditiveNumber(num, j, num.substring(0, i), num.substring(i, j))) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isAdditiveNumber(String s, int index, String a, String b) {
    if (index == s.length()) {
      return true;
    }

    String next = add(a, b);
    if (s.startsWith(next, index)) {
      return isAdditiveNumber(s, index + next.length(), b, next);
    } else {
      return false;
    }
  }

  private String add(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum = 0, temp;
    String res = "";
    while (i >= 0 || j >= 0 || carry > 0) {
      temp = carry;
      if (i >= 0) {
        temp += num1.charAt(i--) - '0';
      }
      if (j >= 0) {
        temp += num2.charAt(j--) - '0';
      }
      carry = temp / 10;
      res += temp % 10;
    }
    return new StringBuilder(res).reverse().toString();
  }
}
