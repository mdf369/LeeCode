package leetcode;

public class FirstBadVersion {

  public int firstBadVersion(int n) {
    return firstBadVersion(1, n + 1);
  }

  private int firstBadVersion(int start, int end) {
    if (start + 1 == end) {
      if (!isBadVersion(start)) {
        start++;
      }
      return start;
    }

    int middle = start + (end - start) / 2;
    if (isBadVersion(middle)) {
      return firstBadVersion(start, middle);
    } else {
      return firstBadVersion(middle, end);
    }
  }

  boolean isBadVersion(int version) {
    return version >= 4;
  }
}
