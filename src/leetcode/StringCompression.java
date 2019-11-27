package leetcode;

public class StringCompression {

  private int getDiffIndex(char[] chars, int start, char c) {
    while (start < chars.length && chars[start] == c) {
      start++;
    }
    return start;
  }

  public int compress(char[] chars) {
    int loopIndex, modifyIndex;
    loopIndex = modifyIndex = 0;

    while (loopIndex < chars.length) {
      int next = getDiffIndex(chars, loopIndex, chars[loopIndex]);
      chars[modifyIndex++] = chars[loopIndex];
      if (next - loopIndex > 1) {
        String numS = String.valueOf(next - loopIndex);
        for (int i = 0; i < numS.length(); i++) {
          chars[modifyIndex++] = numS.charAt(i);
        }
      }
      loopIndex = next;
    }
    return modifyIndex;
  }
}
