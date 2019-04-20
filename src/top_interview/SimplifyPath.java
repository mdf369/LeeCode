package top_interview;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

  private int buildList(String s, int index, List<String> list, int loc) {
    if (index >= s.length()) {
      return loc;
    }

    if (s.charAt(index) == '/') {
      while (index < s.length() && s.charAt(index) == '/') {
        index++;
      }
      if (index == s.length()) {
        return loc;
      }

      int start = index;
      while (index < s.length() && s.charAt(index) != '/') {
        index++;
      }
      String name = s.substring(start, index);
      if (".".equals(name)) {

      } else if ("..".equals(name)) {
        if (loc > 0) {
          loc--;
        }
      } else {
        if (loc >= list.size()) {
          list.add(name);
        } else {
          list.set(loc, name);
        }
        loc++;
      }

      return buildList(s, index, list, loc);
    }

    return -1;
  }

  private String buildPath(List<String> list, int end) {
    if (end == 0) {
      return "/";
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < end; i++) {
      builder.append('/').append(list.get(i));
    }
    return builder.toString();
  }

  public String simplifyPath(String path) {
    while (path.endsWith("/")) {
      path = path.substring(0, path.length() - 1);
    }

    List<String> list = new ArrayList<>();
    int end = buildList(path, 0, list, 0);
    return buildPath(list, end);
  }
}
