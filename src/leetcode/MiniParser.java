package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MiniParser {

  public class NestedInteger {

    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
      return true;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {

    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {

    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      return null;
    }
  }

  public NestedInteger deserialize(String s) {
    return deserialize(s, 0, s.length());
  }

  private NestedInteger deserialize(String s, int start, int end) {
    NestedInteger ni = new NestedInteger();

    if (s.charAt(start) != '[' && s.charAt(end - 1) != ']') {
      ni.setInteger(Integer.parseInt(s.substring(start, end)));
    } else {
      start++;
      end--;

      if (start != end) {
        List<Integer> splitIndexList = getSplitIndexList(s, start, end);
        int pre = start;
        for (Integer splitIndex : splitIndexList) {
          ni.add(deserialize(s, pre, splitIndex));
          pre = splitIndex + 1;
        }
        ni.add(deserialize(s, pre, end));
      }
    }
    return ni;
  }

  private List<Integer> getSplitIndexList(String s, int start, int end) {
    List<Integer> list = new ArrayList<>();
    int count = 0;
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (c == '[') {
        count++;
      } else if (c == ']') {
        count--;
      } else if (c == ',' && count == 0) {
        list.add(i);
      }
    }
    return list;
  }
}
