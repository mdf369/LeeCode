package leetcode;

import java.util.Stack;

public class DailyTemperatures {

  public int[] dailyTemperatures(int[] T) {
    if (T == null) {
      return null;
    }

    Stack<Integer> stack = new Stack<>();
    int[] res = new int[T.length];
    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
        int pre = stack.pop();
        res[pre] = i - pre;
      }
      stack.push(i);
    }
    return res;
  }
}
