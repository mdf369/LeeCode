package top_interview;

public class ReverseWordsInAString {

  public String reverseWords(String s) {
    s = s.trim();
    if (s.length() == 0) {
      return s;
    }
    s = reverse(s);
    String[] words = s.split(" ");

    StringBuilder builder = new StringBuilder();
    for (String word : words) {
      if (word.length() == 0) {
        continue;
      }
      builder.append(reverse(word)).append(" ");
    }
    return builder.substring(0, builder.length() - 1);
  }

  private String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}
