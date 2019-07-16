package leetcode;

import java.util.Stack;

public class BasicCalculator {

  public int calculate(String s) {
    int res = 0, sign = 1, n = s.length();
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; ++i) {
      char c = s.charAt(i);
      if (c >= '0') {
        int num = 0;
        while (i < n && s.charAt(i) >= '0') {
          num = 10 * num + (s.charAt(i++) - '0');
        }
        res += sign * num;
        --i;
      } else if (c == '+') {
        sign = 1;
      } else if (c == '-') {
        sign = -1;
      } else if (c == '(') {
        st.push(res);
        st.push(sign);
        res = 0;
        sign = 1;
      } else if (c == ')') {
        res *= st.pop();
        res += st.pop();
      }
    }
    return res;
  }
}
