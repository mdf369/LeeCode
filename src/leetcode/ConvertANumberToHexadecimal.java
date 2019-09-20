package leetcode;

public class ConvertANumberToHexadecimal {

  private long convertToPositive(long num) {
    return (long) (Math.pow(16, 8) + num);
  }

  private char convert(long num) {
    if (num < 10) {
      return (char) ('0' + num);
    } else {
      return (char) ('a' + num - 10);
    }
  }

  public String toHex(int num) {
    long v = num;
    if (v == 0) {
      return "0";
    }
    if (v < 0) {
      v = convertToPositive(v);
    }

    StringBuilder builder = new StringBuilder();
    while (v > 0) {
      builder.append(convert(v & 15));
      v = v >> 4;
    }
    return builder.reverse().toString();
  }
}
