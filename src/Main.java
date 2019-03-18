import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  private static class Pair {

    private int key;
    private int value;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public int getValue() {
      return value;
    }
  }

  private static boolean isStable(Map<Integer, Integer> map, int n) {
    int count = 0;
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > n / 2) {
        return true;
      }
      count += entry.getValue();
      if (count > n / 2) {
        break;
      }
    }
    return false;
  }

  private static Map<Integer, Integer> count(int[] l) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < l.length; i++) {
      int count = 0;
      if (map.containsKey(l[i])) {
        count = map.get(l[i]);
      }
      map.put(l[i], count + 1);
    }
    return map;
  }

  private static PriorityQueue<Pair> removeAllL(PriorityQueue<Pair> queue, int key) {
    PriorityQueue<Pair> temp = new PriorityQueue<>(queue.size(),
        new Comparator<Pair>() {
          @Override
          public int compare(Pair o1, Pair o2) {
            return ((Integer)o1.getValue()).compareTo(o2.getValue());
          }
        });
    for (Pair pair : queue) {
      if (pair.getKey() != key) {
        temp.add(pair);
      }
    }
    return temp;
  }

  private static boolean allOne(Map<Integer, Integer> map) {
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() != 1) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNextInt()) {
      int n = in.nextInt();
      int[] l = new int[n];
      for (int i = 0; i < n; i++) {
        l[i] = in.nextInt();
      }
      int[] d = new int[n];
      for (int i = 0; i < n; i++) {
        d[i] = in.nextInt();
      }

      if (n <= 1) {
        System.out.println(0);
        continue;
      }

      Map<Integer, Integer> map = count(l);
      if (isStable(map, n)) {
        System.out.println(0);
        continue;
      }

//      PriorityQueue<Pair> queue = new PriorityQueue<>(n,
//          new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//              return ((Integer)o1.getValue()).compareTo(o2.getValue());
//            }
//          });
//      for (int i = 0; i < n; i++) {
//        queue.add(new Pair(l[i], d[i]));
//      }
//
//      if (allOne(map)) {
//        int sum = 0;
//        int count = 0;
//        for (Pair pair : queue) {
//          sum += pair.getValue();
//          count++;
//          if (count == queue.size() - 1) {
//            break;
//          }
//        }
//        System.out.println(sum);
//        continue;
//      }
//
//      int min = Integer.MAX_VALUE;
//      for (Entry<Integer, Integer> entry : map.entrySet()) {
//        if (entry.getKey() == 1) {
//          continue;
//        }
//        PriorityQueue<Pair> tempQueue = removeAllL(queue, entry.getKey());
//        int sum = 0;
//        int count = n - entry.getValue();
//        for (Pair pair : tempQueue) {
//          sum += pair.getValue();
//          count--;
//          if (count < entry.getValue()) {
//            break;
//          }
//        }
//        min = Math.min(min, sum);
//      }
//
//      System.out.println(min);

      int max = 0;
      int key = -1;
      for (Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > max) {
          max = entry.getValue();
          key = entry.getKey();
        }
      }

      int num = map.get(key);
      List<Integer> list = new ArrayList<>(n - num);
      for (int i = 0; i < n; i++) {
        if (l[i] != key) {
          list.add(d[i]);
        }
      }
      Collections.sort(list);

      int sum = 0;
      for (int i = 0; i < n - 2 * num + 1; i++) {
        sum += list.get(i);
      }

      System.out.println(sum);
    }
  }
}
