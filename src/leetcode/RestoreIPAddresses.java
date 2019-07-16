package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

  private final int IP_MAX_LEN = 3;
  private final int IP_MAX_VALUE = 255;
  private final int IP_PART_NUM = 4;

  public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    go(s, new int[IP_MAX_LEN], 0, res);
    return res;
  }

  private void go(String s, int[] indexes, int depth, List<String> res) {
    if (depth == 3) {
      if (validIP(s, indexes[depth - 1], s.length())) {
        res.add(buildIP(s, indexes));
      }
      return;
    }

    int start = depth == 0 ? 0 : indexes[depth - 1];
    for (int i = 1; i <= IP_MAX_LEN && start + i <= s.length(); i++) {
      indexes[depth] = start + i;
      if (validIP(s, start, start + i)) {
        go(s, indexes, depth + 1, res);
      }
    }
  }

  private String buildIP(String s, int[] indexes) {
    StringBuilder builder = new StringBuilder();
    int pre = 0;
    for (int i = 0; i < indexes.length; i++) {
      builder.append(s, pre, indexes[i]).append('.');
      pre = indexes[i];
    }
    builder.append(s, pre, s.length());
    return builder.toString();
  }

  private boolean validIP(String s, int start, int end) {
    if (end - start > IP_MAX_LEN || start >= end) {
      return false;
    }
    if (end - start > 1 && s.charAt(start) == '0') {
      return false;
    }
    int v = Integer.parseInt(s.substring(start, end));
    return v <= IP_MAX_VALUE;
  }
}
