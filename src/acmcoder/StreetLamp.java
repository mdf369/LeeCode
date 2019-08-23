package acmcoder;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class StreetLamp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] ss = scanner.nextLine().split(" ");
    int n = Integer.parseInt(ss[0]);
    int l = Integer.parseInt(ss[1]);
    int[] locs = new int[n];
    for (int i = 0; i < n; i++) {
      locs[i] = scanner.nextInt();
    }
    scanner.close();
    Arrays.sort(locs);

    int max = 0;
    for (int i = 0; i < n - 1; i++) {
      max = Math.max(max, locs[i + 1] - locs[i]);
    }
    double d = max / 2.0;
    d = Math.max(d, locs[0]);
    d = Math.max(d, l - locs[n - 1]);

    DecimalFormat fnum = new DecimalFormat("#0.00");
    String output = fnum.format(d);
    System.out.println(output);
  }
}
