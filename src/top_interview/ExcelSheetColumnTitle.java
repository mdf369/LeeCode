package top_interview;

public class ExcelSheetColumnTitle {

  public String convertToTitle(int n) {
    if (n < 1) {
      return null;
    }

    StringBuilder builder = new StringBuilder();
    while (n > 0) {
      n--;
      int yu = n % 26;
      n = n / 26;
      builder.append((char)('A' + yu));
    }
    return builder.reverse().toString();
  }
}
