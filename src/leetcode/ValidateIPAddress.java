package leetcode;

public class ValidateIPAddress {

  private String[] names = new String[]{"IPv4", "IPv6", "Neither"};

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isIPv4(String ip) {
    if (ip.startsWith(".") || ip.endsWith(".")) {
      return false;
    }

    String[] segments = ip.split("\\.");
    if (segments.length != 4) {
      return false;
    }

    for (String segment : segments) {
      if (segment.length() > 3 || segment.length() < 1 || (segment.length() > 1 && segment.charAt(0) == '0')) {
        return false;
      }

      for (int i = 0; i < segment.length(); i++) {
        if (!isNumber(segment.charAt(i))) {
          return false;
        }
      }

      int v = Integer.parseInt(segment);
      if (v < 0 || v > 255) {
        return false;
      }
    }
    return true;
  }

  private boolean isIPv6(String ip) {
    if (ip.startsWith(":") || ip.endsWith(":")) {
      return false;
    }

    String[] segments = ip.toLowerCase().split(":");
    if (segments.length != 8) {
      return false;
    }

    for (String segment : segments) {
      if (segment.length() > 4 || segment.length() < 1) {
        return false;
      }

      for (int i = 0; i < segment.length(); i++) {
        char c = segment.charAt(i);
        if (!isNumber(c) && !(c >= 'a' && c <= 'f')) {
          return false;
        }
      }
    }
    return true;
  }

  public String validIPAddress(String IP) {
    if (IP == null) {
      return names[2];
    }

    if (IP.contains(".")) {
      if (isIPv4(IP)) {
        return names[0];
      } else {
        return names[2];
      }
    } else if (IP.contains(":")) {
      if (isIPv6(IP)) {
        return names[1];
      } else {
        return names[2];
      }
    } else {
      return names[2];
    }
  }
}
