package leetcode;

public class LicenseKeyFormatting {

  private int nextChar(String s, int start) {
    while (start >= 0) {
      if (s.charAt(start) >= 'A' && s.charAt(start) <= 'Z' || s.charAt(start) >= '0' && s.charAt(start) <= '9') {
        break;
      } else {
        start--;
      }
    }
    return start;
  }

  public String licenseKeyFormatting(String S, int K) {
    S = S.toUpperCase();

    if (K == 0) {
      return S.replace("-", "");
    }

    StringBuilder builder = new StringBuilder();
    int index = S.length();
    while (index >= 0) {
      index = nextChar(S, index - 1);
      if (index == -1) {
        break;
      }
      builder.append(S.charAt(index));
      if (builder.length() % (K + 1) == K) {
        builder.append('-');
      }
    }

    String res = builder.reverse().toString();
    if (res.startsWith("-")) {
      res = res.substring(1);
    }
    return res;
  }
}
