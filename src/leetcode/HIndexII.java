package leetcode;

public class HIndexII {

  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }
    return hIndex(citations, 0, citations.length);
  }

  public int hIndex(int[] citations, int start, int end) {
    if (start >= citations.length) {
      return 0;
    }

    if (start + 1 >= end) {
      if (!isValid(citations, start)) {
        start++;
      }
      return citations.length - start;
    }

    int middle = start + (end - start) / 2;
    if (isValid(citations, middle)) {
      return hIndex(citations, start, middle);
    } else {
      return hIndex(citations, middle + 1, end);
    }
  }

  private boolean isValid(int[] citations, int index) {
    return citations[index] >= citations.length - index;
  }
}
