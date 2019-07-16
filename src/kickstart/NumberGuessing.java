package kickstart;

import java.util.Scanner;

public class NumberGuessing {

  public void guess(long a, long b, int n, Scanner scanner) {
    for (int i = 0; i < n; i++) {
      long middle = a + (long) Math.ceil((b - a) / 2.0);
      System.out.println(middle);
      String res = scanner.nextLine();
      if (res.equals("CORRECT")) {
        break;
      } else if (res.equals("TOO_BIG")) {
        b = middle - 1;
      } else {
        a = middle;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    NumberGuessing guessing = new NumberGuessing();

    int t = scanner.nextInt();
    long a,b;
    int n;
    for (int i = 0; i < t; i++) {
      a = scanner.nextLong();
      b = scanner.nextLong();
      n = scanner.nextInt();
      scanner.nextLine();
      guessing.guess(a, b, n, scanner);
    }
    scanner.close();
  }
}
