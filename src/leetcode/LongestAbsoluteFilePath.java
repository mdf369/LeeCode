package leetcode;

import java.util.Stack;

public class LongestAbsoluteFilePath {

  private int MAX_LEN = 0;

  private boolean isFile(String path) {
    return path.contains(".");
  }

  private int getDegree(String path) {
    int count = 0;
    for (int i = 0; i < path.length() && path.charAt(i) == '\t'; i++) {
      count++;
    }
    return count;
  }

  public int lengthLongestPath(String input) {
    String[] paths = input.split("\n");

    int curLen = 0;
    Stack<String> stack = new Stack<>();
    for (String path : paths) {
      int degree = getDegree(path);
      while (degree < stack.size()) {
        String dir = stack.pop();
        curLen -= dir.length() + 1;
      }
      path = path.substring(degree);

      if (isFile(path)) {
        MAX_LEN = Math.max(MAX_LEN, curLen + path.length());
      } else {
        stack.push(path);
        curLen += path.length() + 1;
      }
    }

    return MAX_LEN;
  }
}
