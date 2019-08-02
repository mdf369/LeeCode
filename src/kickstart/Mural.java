package kickstart;

import java.util.Scanner;

public class Mural {

  public static int paint(int N, int[] scores) {
    int len = (int) Math.ceil(N / 2.0);
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += scores[i];
    }

    int max = sum;
    for (int i = 0; i < N - len; i++) {
      sum = sum - scores[i] + scores[i + len];
      max = Math.max(max, sum);
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(scanner.nextLine());
      int[] scores = new int[N];
      char[] chars = scanner.nextLine().toCharArray();
      for (int j = 0; j < N; j++) {
        scores[j] = chars[j] - '0';
      }
      System.out.println("Case #" + (i + 1) + ": " + Mural.paint(N, scores));
    }
    scanner.close();
  }
}
