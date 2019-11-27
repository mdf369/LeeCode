package leetcode;

public class AddStrings {

  private int addChar(char c1, char c2) {
    return c1 + c2 - '0' * 2;
  }

  public String addStrings(String num1, String num2) {
    int shift = 0;
    StringBuilder builder = new StringBuilder();
    int index1 = num1.length() - 1;
    int index2 = num2.length() - 1;
    while (index1 >= 0 && index2 >= 0) {
      int sum = addChar(num1.charAt(index1), num2.charAt(index2)) + shift;
      shift = sum / 10;
      builder.append(sum % 10);

      index1--;
      index2--;
    }

    if (index1 < 0 && index2 < 0) {
      if (shift > 0) {
        builder.append(shift);
      }

      return builder.reverse().toString();
    } else {
      String s = index1 >= 0 ? num1 : num2;
      int index = Math.max(index1, index2);

      while (index >= 0 && shift > 0) {
        int sum = s.charAt(index) - '0' + shift;
        shift = sum / 10;
        builder.append(sum % 10);
        index--;

        if (sum < 10) {
          break;
        }
      }

      if (index < 0 && shift > 0) {
        builder.append(shift);
      }

      String res = builder.reverse().toString();
      if (index >= 0) {
        res = s.substring(0, index + 1) + res;
      }
      return res;
    }
  }
}
