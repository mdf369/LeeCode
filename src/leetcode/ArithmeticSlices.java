package leetcode;

public class ArithmeticSlices {

  private int getArithmeticEnd(int[] A, int start) {
    if (start >= A.length - 1) {
      return start + 1;
    }

    int pre = A[start + 1] - A[start];
    int index = start + 2;
    while (index < A.length && A[index] - A[index - 1] == pre) {
      index++;
    }

    if (index == start + 2) {
      return start + 1;
    } else {
      return index;
    }
  }

  private int getArithmeticCount(int len) {
    if (len < 3) {
      return 0;
    }

    return (len - 1) * (len - 2) / 2;
  }

  public int numberOfArithmeticSlices(int[] A) {
    if (A.length < 3) {
      return 0;
    }

    int start = 0;
    int end;
    int count = 0;
    while ((end = getArithmeticEnd(A, start)) <= A.length) {
      count += getArithmeticCount(end - start);
      start = end;
    }
    return count;
  }
}
