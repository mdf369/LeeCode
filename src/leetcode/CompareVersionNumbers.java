package leetcode;

public class CompareVersionNumbers {

  public int compareVersion(String version1, String version2) {
    int res = 0;

    String[] versions1 = version1.split("\\.");
    String[] versions2 = version2.split("\\.");

    boolean swap = false;
    if (version1.length() < version2.length()) {
      swap = true;
      String[] t = versions1;
      versions1 = versions2;
      versions2 = t;
    }

    for (int i = 0; i < versions2.length; i++) {
      res = compareStr(versions1[i], versions2[i]);
      if (res != 0) {
        break;
      }
    }

    if (res == 0) {
      if (versions1.length > versions2.length) {
        if (isRestAllZero(versions1, versions2.length)) {
          return 0;
        } else {
          return swap ? -1 : 1;
        }
      } else {
        return 0;
      }
    } else {
      return swap ? -res : res;
    }
  }

  private boolean isRestAllZero(String[] versions, int start) {
    for (int i = start; i < versions.length; i++) {
      if (Integer.parseInt(versions[i]) != 0) {
        return false;
      }
    }
    return true;
  }

  private int compareStr(String s1, String s2) {
    int num1 = Integer.parseInt(s1);
    int num2 = Integer.parseInt(s2);

    if (num1 > num2) {
      return 1;
    } else if (num1 < num2) {
      return -1;
    } else {
      return 0;
    }
  }
}
