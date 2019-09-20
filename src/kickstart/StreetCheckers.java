package kickstart;

import java.util.Scanner;

public class StreetCheckers {

  private static boolean isOddPrime(int X) {
    if (X == 3) {
      return true;
    }

    if (X % 6 != 1 && X % 6 != 5) {
      return false;
    }
    int sqrt = (int) Math.sqrt(X);
    for (int i = 5; i <= sqrt; i += 6) {
      if (X % i == 0 || X % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean isInteresting(int X) {
    int n = 0;
    while ((X & 1) != 1) {
      X = X >> 1;
      n++;
    }

    if (X == 1) {
      return n <= 3;
    } else if (isOddPrime(X)) {
      return n <= 2;
    } else {
      return n == 1;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int L = scanner.nextInt();
      int R = scanner.nextInt();

      int count = 0;
      for (int i = L; i <= R; i++) {
        if (isInteresting(i)) {
          count++;
        }
      }


      System.out.println("Case #" + (t + 1) + ": " + count);
    }
    scanner.close();
  }
}
