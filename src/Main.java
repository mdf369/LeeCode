import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      int V = scanner.nextInt();
      int N = scanner.nextInt();

      int[] prices = new int[N];
      for (int i = 0; i < N; i++) {
        prices[i] = scanner.nextInt();
      }

      int M = scanner.nextInt();
      int[] priorities = new int[N];
      Set<Integer> likeSet = new HashSet<>();
      for (int i = 0; i < M; i++) {
        int index = scanner.nextInt() - 1;
        priorities[i] = prices[index];
        likeSet.add(index);
      }

      int index = M;
      for (int i = 0; i < N; i++) {
        if (likeSet.contains(i)) {
          continue;
        }

        priorities[index] = prices[i];
        index++;
      }

      int must = 0;
      int num = 0;
      for (int i = M - 1; i >= 0; i--) {
        must += num * priorities[i];
        num++;
      }

      System.out.println(go(priorities, M, 0, V - must, Integer.MAX_VALUE));
    }
    scanner.close();
  }

  private static int go(int[] priorities, int M, int index, int left, int limit) {
    if (left == 0) {
      return 1;
    }
    if (left < 0) {
      return 0;
    }
    if (index >= priorities.length) {
      return 0;
    }

    if (index >= M) {
      limit = Integer.MAX_VALUE;
    }
    int res = go(priorities, M, index + 1, left, 0);
    int count = 0;
    int price = priorities[index];
    while (left > 0 && count < limit) {
      count++;
      left -= price;

      res = (res + go(priorities, M, index + 1, left, count)) % 10000007;
    }
    return res;
  }
}