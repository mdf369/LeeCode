package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FizzBuzz {

  public List<String> fizzBuzz(int n) {
    if (n < 1) {
      return Collections.emptyList();
    }

    List<String> res = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      StringBuilder builder = new StringBuilder();
      if (i % 3 == 0 || i % 5 == 0) {
        if (i % 3 == 0) {
          builder.append("Fizz");
        }
        if (i % 5 == 0) {
          builder.append("Buzz");
        }
      } else {
        builder.append(i);
      }
      res.add(builder.toString());
    }
    return res;
  }
}
