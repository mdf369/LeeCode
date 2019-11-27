package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {

  private int getMaxYue(int n, int m) {
    if (n == 0 || m == 0) {
      return n + m;
    }

    if (n < m) {
      int t = n;
      n = m;
      m = t;
    }
    int t;
    while ((t = n % m) != 0) {
      n = m;
      m = t;
    }
    return m;
  }

  private List<Integer> getFactorList(int n) {
    List<Integer> list = new ArrayList<>();
    list.add(n);
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        list.add(i);
        list.add(n / i);
      }
    }
    return list;
  }

  private boolean canDivide(String s, int num) {
    if (num < 2) {
      return false;
    }

    int len = s.length() / num;
    String sub = s.substring(0, len);
    for (int i = 1; i < num; i++) {
      if (!sub.equals(s.substring(i * len, (i + 1) * len))) {
        return false;
      }
    }
    return true;
  }

  public boolean repeatedSubstringPattern(String s) {
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counts[s.charAt(i) - 'a']++;
    }

    int yue = -1;
    for (int count : counts) {
      if (yue == -1) {
        yue = count;
      } else {
        yue = getMaxYue(yue, count);
      }
    }

    List<Integer> factorList = getFactorList(yue);
    for (Integer factor : factorList) {
      if (canDivide(s, factor)) {
        return true;
      }
    }
    return false;
  }
}
