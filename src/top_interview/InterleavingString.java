package top_interview;

public class InterleavingString {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    int[][] mem = new int[s1.length() + 1][s2.length() + 1];
    int flag = 1;
    for (int i = 1; i <= s1.length(); i++) {
      if (flag == 1 && s1.charAt(s1.length() - i) != s3.charAt(s3.length() - i)) {
        flag = -1;
      }
      mem[s1.length() - i][s2.length()] = flag;
    }
    flag = 1;
    for (int i = 1; i <= s2.length(); i++) {
      if (flag == 1 && s2.charAt(s2.length() - i) != s3.charAt(s3.length() - i)) {
        flag = -1;
      }
      mem[s1.length()][s2.length() - i] = flag;
    }
    mem[s1.length()][s2.length()] = 1;
    return isInterleave(s1, 0, s2, 0, s3, mem);
  }

  private boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int[][] mem) {
    if (mem[index1][index2] != 0) {
      return mem[index1][index2] == 1;
    }

    char target = s3.charAt(index1 + index2);
    char c1 = s1.charAt(index1);
    char c2 = s2.charAt(index2);

    boolean flag = false;
    if (target == c1 && target == c2) {
      flag = isInterleave(s1, index1 + 1, s2, index2, s3, mem)
          || isInterleave(s1, index1, s2, index2 + 1, s3, mem);
    } else if (target == c1) {
      flag = isInterleave(s1, index1 + 1, s2, index2, s3, mem);
    } else if (target == c2) {
      flag = isInterleave(s1, index1, s2, index2 + 1, s3, mem);
    } else {
      flag = false;
    }

    mem[index1][index2] = flag ? 1 : 0;
    return flag;
  }
}
