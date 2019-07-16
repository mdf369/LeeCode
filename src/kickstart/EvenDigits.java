package kickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EvenDigits {

  public long compute(long num) {
    List<Integer> digitList = split(num);
    for (int i = 0; i < digitList.size(); i++) {
      if ((digitList.get(i) & 1) == 0) {
        continue;
      }

      int loc = digitList.size() - i - 1;
      long high = (long) Math.pow(10, loc);
      long low = buildLow(loc);
      long rest = num % high;
      if (digitList.get(i) == 9) {
        return rest + high - low;
      } else {
        return Math.min(high - rest, rest + high - low);
      }
    }
    return 0;
  }

  private long buildLow(int size) {
    long low = 0;
    for (int i = 0; i < size; i++) {
      low = low * 10 + 8;
    }
    return low;
  }

  private List<Integer> split(long num) {
    List<Integer> digitList = new ArrayList<>();
    while (num > 0) {
      digitList.add(0, (int) (num % 10));
      num /= 10;
    }
    return digitList;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    EvenDigits evenDigits = new EvenDigits();
    int N = scanner.nextInt();
    for (int i = 0; i < N; i++) {
      long num = scanner.nextLong();
      System.out.println("Case #" + (i + 1) + ": " + evenDigits.compute(num));
    }
    scanner.close();
  }
}
