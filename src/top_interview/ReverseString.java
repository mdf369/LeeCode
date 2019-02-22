package top_interview;

public class ReverseString {

  public void reverseString(char[] s) {
    if (s == null || s.length < 2) {
      return;
    }

    int start = 0;
    int end = s.length - 1;
    while (start < end) {
      swap(s, start, end);
      start++;
      end--;
    }
  }

  private void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }
}
