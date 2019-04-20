package top_interview;

public class IntegerToRoman {

  public String intToRoman(int num) {
    StringBuilder builder = new StringBuilder();
    intToRoman(num, builder);
    return builder.toString();
  }

  private void intToRoman(int num, StringBuilder builder) {
    if (num == 0) {
      return;
    }else if (num >= 1000) {
      builder.append('M');
      intToRoman(num - 1000, builder);
    } else if (num < 1000 && num >= 900) {
      builder.append("CM");
      intToRoman(num - 900, builder);
    } else if (num < 900 && num >= 500) {
      builder.append('D');
      intToRoman(num - 500, builder);
    } else if (num < 500 && num >= 400) {
      builder.append("CD");
      intToRoman(num - 400, builder);
    } else if (num < 400 && num >= 100) {
      builder.append('C');
      intToRoman(num - 100, builder);
    } else if (num < 100 && num >= 90) {
      builder.append("XC");
      intToRoman(num - 90, builder);
    } else if (num < 90 && num >= 50) {
      builder.append('L');
      intToRoman(num - 50, builder);
    } else if (num < 50 && num >= 40) {
      builder.append("XL");
      intToRoman(num - 40, builder);
    } else if (num < 40 && num >= 10) {
      builder.append('X');
      intToRoman(num - 10, builder);
    } else if (num < 10 && num >= 9) {
      builder.append("IX");
      intToRoman(num - 9, builder);
    } else if (num < 9 && num >= 5) {
      builder.append('V');
      intToRoman(num - 5, builder);
    } else if (num < 5 && num >= 4) {
      builder.append("IV");
      intToRoman(num - 4, builder);
    } else {
      builder.append('I');
      intToRoman(num - 1, builder);
    }
  }
}
