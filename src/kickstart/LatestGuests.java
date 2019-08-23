package kickstart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LatestGuests {

  private static int getDis(int conLoc, int guestLoc, int shift, int N) {
    int dis = ((guestLoc - conLoc) * shift + N) % N;
    return dis;
  }

  private static List<Integer> getNearestGuest(int loc, int[] H, int[] S, int N, int G, int M) {
    List<Integer> guests = new ArrayList<>();
    int minDis = Integer.MAX_VALUE;
    for (int i = 0; i < G; i++) {
      int dis = getDis(loc, H[i], S[i], N);
      if (dis > M || dis > minDis) {
        continue;
      } else if (dis == minDis) {
        guests.add(i);
      } else {
        minDis = dis;
        guests.clear();
        guests.add(i);
      }
    }
    return guests;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = Integer.parseInt(scanner.nextLine());
    for (int t = 0; t < T; t++) {
      String[] words = scanner.nextLine().split(" ");
      int N = Integer.parseInt(words[0]);
      int G = Integer.parseInt(words[1]);
      int M = Integer.parseInt(words[2]);

      int[] H = new int[G];
      int[] S = new int[G];
      for (int i = 0; i < G; i++) {
        words = scanner.nextLine().split(" ");
        H[i] = Integer.parseInt(words[0]) - 1;
        S[i] = words[1].equals("C") ? 1 : -1;
      }

      List<Integer>[] consulates = new List[N];
      for (int i = 0; i < N; i++) {
        consulates[i] = new ArrayList<>();
      }
      for (int i = 0; i < G; i++) {
        H[i] = (H[i] + S[i] * (M % N) + N) % N;
        consulates[H[i]].add(i);
      }

      for (int i = 0; i < N; i++) {
        if (consulates[i].isEmpty()) {
          consulates[i].addAll(getNearestGuest(i, H, S, N, G, M));
        }
      }

      int[] res = new int[G];
      for (int i = 0; i < N; i++) {
        for (Integer guest : consulates[i]) {
          res[guest]++;
        }
      }

      StringBuilder builder = new StringBuilder();
      builder.append("Case #" + (t + 1) + ":");
      for (int i = 0; i < G; i++) {
        builder.append(" ").append(res[i]);
      }
      System.out.println(builder.toString());
    }
    scanner.close();
  }
}
