package kickstart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class CherriesMesh {

  private static int isConnected(Map<Integer, Set<Integer>> lineMap, int N, int[] visited, int start, int count) {
    Stack<Integer> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      int node = stack.pop();
      if (visited[node] == 1) {
        continue;
      }

      count++;
      visited[node] = 1;
      if (count == N) {
        break;
      }
      if (!lineMap.containsKey(node)) {
        break;
      }
      for (Integer index : lineMap.get(node)) {
        stack.push(index);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int N = scanner.nextInt();
      int M = scanner.nextInt();
      Map<Integer, Set<Integer>> bLines = new HashMap<>();
      for (int i = 0; i < M; i++) {
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        if (!bLines.containsKey(x)) {
          bLines.put(x, new HashSet<>());
        }
        bLines.get(x).add(y);
        if (!bLines.containsKey(y)) {
          bLines.put(y, new HashSet<>());
        }
        bLines.get(y).add(x);
      }

      int res = N - 1;
      int[] visited = new int[N];
      int count = 0;
      int start = 0;
      while (true) {
        count = isConnected(bLines, N, visited, start, count);
        if (count == N) {
          break;
        }
        while (start < N && visited[start] == 1) {
          start++;
        }
        res++;
      }


      System.out.println("Case #" + (t + 1) + ": " + res);
    }
    scanner.close();
  }
}
