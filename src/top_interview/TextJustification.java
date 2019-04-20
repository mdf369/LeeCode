package top_interview;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

  public List<String> fullJustify(String[] words, int maxWidth) {
    int index = 0;
    List<String> lineList = new ArrayList<>();
    while (index < words.length) {
      List<String> candidates = new ArrayList<>();
      int rest = maxWidth + 1;
      while (index < words.length && words[index].length() + 1 <= rest) {
        candidates.add(words[index]);
        rest -= words[index].length() + 1;
        index++;
      }

      if (index < words.length) {
        lineList.add(buildLine(candidates, maxWidth));
      } else {
        lineList.add(buildLastLine(candidates, maxWidth));
      }
    }
    return lineList;
  }

  private String buildLastLine(List<String> wordList, int len) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < wordList.size(); i++) {
      builder.append(wordList.get(i));
      len -= wordList.get(i).length();
      if (len > 0) {
        builder.append(' ');
        len--;
      }
    }
    for (int i = 0; i < len; i++) {
      builder.append(' ');
    }
    return builder.toString();
  }

  private String buildLine(List<String> wordList, int len) {
    if (wordList.size() == 1) {
      StringBuilder builder = new StringBuilder();
      builder.append(wordList.get(0));
      for (int i = 0; i < len - wordList.get(0).length(); i++) {
        builder.append(' ');
      }
      return builder.toString();
    }

    int wordLen = wordList.stream().mapToInt(String::length).sum();
    int spaceTotalLen = len - wordLen;
    int[] spaceLens = splitSpaces(spaceTotalLen, wordList.size() - 1);

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < wordList.size() - 1; i++) {
      builder.append(wordList.get(i));
      for (int j = 0; j < spaceLens[i]; j++) {
        builder.append(' ');
      }
    }
    builder.append(wordList.get(wordList.size() - 1));
    return builder.toString();
  }

  private int[] splitSpaces(int len, int num) {
    int[] res = new int[num];
    int ave = len / num;
    for (int i = 0; i < res.length; i++) {
      res[i] = ave;
    }
    len -= ave * num;
    for (int i = 0; i < res.length && len > 0; i++) {
      res[i]++;
      len--;
    }
    return res;
  }
}
