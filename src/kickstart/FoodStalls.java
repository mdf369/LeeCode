package kickstart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FoodStalls {

  private static class Spot implements Comparable<Spot> {
    int loc;
    int cost;

    @Override
    public int compareTo(Spot o) {
      return loc - o.loc;
    }
  }

  private static int getMinCost(Spot[] spots, int index, int N, int K) {
    List<Integer> list = new ArrayList<>(N - 1);
    for (int i = 0; i < N; i++) {
      if (i == index) {
        continue;
      }
      list.add(spots[i].cost);
    }
    Collections.sort(list);

    int cost = spots[index].cost;
    for (int i = 0; i < K; i++) {
      cost += list.get(i);
    }
    return cost;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int K = scanner.nextInt();
      int N = scanner.nextInt();

      Spot[] spots = new Spot[N];
      for (int i = 0; i < N; i++) {
        spots[i] = new Spot();
        spots[i].loc = scanner.nextInt();
      }
      for (int i = 0; i < N; i++) {
        spots[i].cost = scanner.nextInt();
      }

      Arrays.sort(spots);
      
      long locCost = 0;
      for (int i = 0; i < K + 1; i++) {
        locCost += spots[i].cost;
      }

      long disCost = 0;
      int middle = K / 2;
      int left = middle;
      int right = K - left;
      long tempCost = 0;
      for (int i = 0; i < left; i++) {
        int index = middle - i;
        tempCost += spots[index].loc - spots[index - 1].loc;
        disCost += tempCost;
      }
      tempCost = 0;
      for (int i = 0; i < right; i++) {
        int index = middle + i;
        tempCost += spots[index + 1].loc - spots[index].loc;
        disCost += tempCost;
      }
      
      long minCost = locCost + disCost;
      int shift = (K & 1) == 1 ? 1 : 0;
      for (int start = 1; start < N - K; start++) {
        locCost += spots[start + K].cost - spots[start - 1].cost;

        disCost += spots[middle + 1 + right].loc - spots[middle + 1].loc;
        disCost -= spots[middle + shift].loc - spots[middle - left].loc;
        middle++;

        minCost = Math.min(minCost, locCost + disCost);
      }

      System.out.println("Case #" + (t + 1) + ": " + minCost);
    }
    scanner.close();
  }
}
