package kickstart;

import java.util.Scanner;

public class KickstartAlarm {

  private static final int MODULO = 1000000007;

  private static int geoSum(int base,int n) {
    if (n == 1) {
      return base;
    }
    long tmp = geoSum(base, n / 2);
    tmp = (tmp + tmp * pow(base, n / 2)) % MODULO;
    if (n % 2 == 1) {
      tmp = (tmp + pow(base, n)) % MODULO;
    }
    return (int) tmp;
  }

  public static long compute(long[] A, int K) {
    for (int i = 0; i < A.length; i++) {
      A[i] = (A[i] * (A.length - i)) % MODULO;
    }

    long sum = 0;
    long subsum = 0;
    for (int i = 0; i < A.length; i++) {
      subsum = (subsum + geoSum(i + 1, K)) % MODULO;
      sum = (sum + A[i] * subsum) % MODULO;
    }
    return sum;
  }

  private static long computeEx(int x, int K) {
    if (x == 1) {
      return K;
    }
    return ((pow(x, K + 1) - x) / (x - 1)) % MODULO;
  }

  private static long pow(int base, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return base;
    }

    long half = pow(base, n / 2);
    long res = (half * half) % MODULO;
    if (n % 2 == 1) {
      res = (res * base) % MODULO;
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < T; i++) {
      String[] words = scanner.nextLine().split(" ");
      int N = Integer.parseInt(words[0]);
      int K = Integer.parseInt(words[1]);
      int x1 = Integer.parseInt(words[2]);
      int y1 = Integer.parseInt(words[3]);
      int C = Integer.parseInt(words[4]);
      int D = Integer.parseInt(words[5]);
      int E1 = Integer.parseInt(words[6]);
      int E2 = Integer.parseInt(words[7]);
      int F = Integer.parseInt(words[8]);

      long[] A = new long[N];
      int preX = x1;
      int preY = y1;
      for (int j = 0; j < N; j++) {
        A[j] = (preX + preY) % F;
        x1 = (C * preX + D * preY + E1) % F;
        y1 = (D * preX + C * preY + E2) % F;
        preX = x1;
        preY = y1;
      }

      System.out.println("Case #" + (i + 1) + ": " + KickstartAlarm.compute(A, K));
    }
    scanner.close();
  }
}
