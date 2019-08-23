package kickstart;

import java.util.Scanner;

public class XOrWhat {

  private static int getSetBitNum(int num) {
    int count = 0;
    while (num > 0) {
      if ((num & 1) == 1) {
        count++;
      }
      num = num >> 1;
    }
    return count;
  }

  private static int countSetBit(int[] arr) {
    int count = 0;
    for (int n : arr) {
      if (n == 1) {
        count++;
      }
    }
    return count;
  }

  private static boolean isOdd(int num) {
    return (num & 1) == 1;
  }

  private static boolean IS_ODD_NUM_ODD;
  private static int LEFT_ODD_INDEX;
  private static int RIGHT_ODD_INDEX;

  private static void init(int[] setBitNums, int N) {
    int oddNum = 0;
    for (int i = 0; i < N; i++) {
      if (isOdd(setBitNums[i])) {
        oddNum++;
      }
    }
    IS_ODD_NUM_ODD = isOdd(oddNum);

    if (oddNum == 0) {
      LEFT_ODD_INDEX = N;
      RIGHT_ODD_INDEX = -1;
      return;
    }

    int left = 0;
    while (!isOdd(setBitNums[left])) {
      left++;
    }
    LEFT_ODD_INDEX = left;

    int right = N - 1;
    while (!isOdd(setBitNums[right])) {
      right--;
    }
    RIGHT_ODD_INDEX = right;
  }

  private static int updateAndGet(int[] setBitNums, int N, int index, int newValue) {
    int newSetBitNum = getSetBitNum(newValue);
    if (isOdd(setBitNums[index]) != isOdd(newSetBitNum)) {
      IS_ODD_NUM_ODD = !IS_ODD_NUM_ODD;
    }
    setBitNums[index] = newSetBitNum;

    if (isOdd(newSetBitNum)) {
      LEFT_ODD_INDEX = Math.min(LEFT_ODD_INDEX, index);
      RIGHT_ODD_INDEX = Math.max(RIGHT_ODD_INDEX, index);
    } else {
      if (index == LEFT_ODD_INDEX) {
        while (LEFT_ODD_INDEX < N && !isOdd(setBitNums[LEFT_ODD_INDEX])) {
          LEFT_ODD_INDEX++;
        }
      }
      if (index == RIGHT_ODD_INDEX) {
        while (RIGHT_ODD_INDEX >= 0 && !isOdd(setBitNums[RIGHT_ODD_INDEX])) {
          RIGHT_ODD_INDEX--;
        }
      }
    }

    if (!IS_ODD_NUM_ODD) {
      return N;
    } else {
      return N - Math.min(LEFT_ODD_INDEX, N - 1 - RIGHT_ODD_INDEX) - 1;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      int Q = scanner.nextInt();

      int[] A = new int[N];
      for (int j = 0; j < N; j++) {
        A[j] = scanner.nextInt();
      }

      int[] P = new int[Q];
      int[] V = new int[Q];
      for (int j = 0; j < Q; j++) {
        P[j] = scanner.nextInt();
        V[j] = scanner.nextInt();
      }

      int[] setBitNums = new int[N];
      for (int j = 0; j < N; j++) {
        setBitNums[j] = getSetBitNum(A[j]);
      }

      init(setBitNums, N);
      int[] res = new int[Q];
      for (int j = 0; j < Q; j++) {
        res[j] = updateAndGet(setBitNums, N, P[j], V[j]);
      }

      StringBuilder builder = new StringBuilder();
      builder.append("Case #" + (i + 1) + ":");
      for (int num : res) {
        builder.append(" " + num);
      }
      System.out.println(builder.toString());
    }
    scanner.close();
  }
}
