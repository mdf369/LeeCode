package acmcoder;

import java.util.Scanner;

public class Cross {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      int n = scanner.nextInt();

      n--;
      int width = (int) Math.pow(3, n);
      char[][] board = new char[width][width];
      int loc = (width - 1) / 2;
      paint(board, loc, loc, width);

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          if (board[i][j] == '\u0000') {
            System.out.print(' ');
          } else {
            System.out.print(board[i][j]);
          }
        }
        System.out.println();
      }
    }
    scanner.close();
  }

  private static void paint(char[][] borad, int x, int y, int width) {
    if (width == 1) {
      borad[x][y] = 'o';
      return;
    }

    width = width / 3;
    paint(borad, x - width, y, width);
    paint(borad, x, y - width, width);
    paint(borad, x, y, width);
    paint(borad, x, y + width, width);
    paint(borad, x + width, y, width);
  }
}
