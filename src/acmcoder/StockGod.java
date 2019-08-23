package acmcoder;

import java.util.Scanner;

public class StockGod {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      int day = Integer.parseInt(scanner.nextLine());
      if (day == 1) {
        System.out.println(1);
        continue;
      }

      int loop = getLoopIndex(day);
      int rest = day - (loop - 1) * loop / 2;
      int price = 1 + (loop - 2) * (loop - 3) / 2;
      if (loop == rest) {
        price += loop - 2;
      } else {
        price += rest;
      }
      System.out.println(price);
    }
    scanner.close();
  }

  private static int getLoopIndex(int day) {
    int limit = (int) Math.sqrt(day * 2);
    if (day * 2 > limit * (limit + 1)) {
      return limit + 1;
    } else {
      return limit;
    }
  }
}
